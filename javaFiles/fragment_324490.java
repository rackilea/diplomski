import sun.jvm.hotspot.code.Location;
import sun.jvm.hotspot.code.LocationValue;
import sun.jvm.hotspot.code.NMethod;
import sun.jvm.hotspot.code.ScopeValue;
import sun.jvm.hotspot.code.VMRegImpl;
import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.interpreter.OopMapCacheEntry;
import sun.jvm.hotspot.oops.Method;
import sun.jvm.hotspot.oops.Oop;
import sun.jvm.hotspot.runtime.CompiledVFrame;
import sun.jvm.hotspot.runtime.InterpretedVFrame;
import sun.jvm.hotspot.runtime.JavaThread;
import sun.jvm.hotspot.runtime.JavaVFrame;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMReg;
import sun.jvm.hotspot.tools.Tool;

import java.util.List;

public class Frames extends Tool {

    @Override
    public void run() {
        for (JavaThread thread = VM.getVM().getThreads().first(); thread != null; thread = thread.next()) {
            System.out.println(thread.getThreadName() + ", id = " + thread.getOSThread().threadId());
            for (JavaVFrame vf = thread.getLastJavaVFrameDbg(); vf != null; vf = vf.javaSender()) {
                dumpFrame(vf);
            }
            System.out.println();
        }
    }

    private void dumpFrame(JavaVFrame vf) {
        Method method = vf.getMethod();
        String className = method.getMethodHolder().getName().asString().replace('/', '.');
        String methodName = method.getName().asString() + method.getSignature().asString();
        System.out.println("  # " + className + '.' + methodName + " @ " + vf.getBCI());

        if (vf.isCompiledFrame()) {
            dumpCompiledFrame(((CompiledVFrame) vf));
        } else {
            dumpInterpretedFrame(((InterpretedVFrame) vf));
        }
    }

    private void dumpCompiledFrame(CompiledVFrame vf) {
        if (vf.getScope() == null) {
            return;
        }

        NMethod nm = vf.getCode();
        System.out.println("    * code=[" + nm.codeBegin() + "-" + nm.codeEnd() + "], pc=" + vf.getFrame().getPC());

        List locals = vf.getScope().getLocals();
        for (int i = 0; i < locals.size(); i++) {
            ScopeValue sv = (ScopeValue) locals.get(i);
            if (!sv.isLocation()) continue;

            Location loc = ((LocationValue) sv).getLocation();
            Address addr = null;
            String regName = "";

            if (loc.isRegister()) {
                int reg = loc.getRegisterNumber();
                addr = vf.getRegisterMap().getLocation(new VMReg(reg));
                regName = ":" + VMRegImpl.getRegisterName(reg);
            } else if (loc.isStack() && !loc.isIllegal()) {
                addr = vf.getFrame().getUnextendedSP().addOffsetTo(loc.getStackOffset());
            }

            String value = getValue(addr, loc.getType());
            System.out.println("    [" + i + "] " + addr + regName + " = " + value);
        }
    }

    private void dumpInterpretedFrame(InterpretedVFrame vf) {
        Method method = vf.getMethod();
        int locals = (int) (method.isNative() ? method.getSizeOfParameters() : method.getMaxLocals());
        OopMapCacheEntry oopMask = method.getMaskFor(vf.getBCI());

        for (int i = 0; i < locals; i++) {
            Address addr = vf.getFrame().addressOfInterpreterFrameLocal(i);
            String value = getValue(addr, oopMask.isOop(i) ? Location.Type.OOP : Location.Type.NORMAL);
            System.out.println("    [" + i + "] " + addr + " = " + value);
        }
    }

    private String getValue(Address addr, Location.Type type) {
        if (type == Location.Type.INVALID || addr == null) {
            return "(invalid)";
        } else if (type == Location.Type.OOP) {
            return "(oop) " + getOopName(addr.getOopHandleAt(0));
        } else if (type == Location.Type.NARROWOOP) {
            return "(narrow_oop) " + getOopName(addr.getCompOopHandleAt(0));
        } else if (type == Location.Type.NORMAL) {
            return "(int) 0x" + Integer.toHexString(addr.getJIntAt(0));
        } else {
            return "(" + type + ") 0x" + Long.toHexString(addr.getJLongAt(0));
        }
    }

    private String getOopName(OopHandle hadle) {
        if (hadle == null) {
            return "null";
        }
        Oop oop = VM.getVM().getObjectHeap().newOop(hadle);
        return oop.getKlass().getName().asString();
    }

    public static void main(String[] args) throws Exception {
        new Frames().execute(args);
    }
}