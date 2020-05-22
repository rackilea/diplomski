import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class ClassTransformer implements ClassFileTransformer{
    public byte[] transform(ClassLoader    loader,
            String              className,
            Class            classBeingRedefined,
            ProtectionDomain    protectionDomain,
            byte[]              b)
                    throws IllegalClassFormatException {
        try
        {
                ClassReader cr=new ClassReader(b);
                ClassWriter cw = new ClassWriter(cr,ClassWriter.COMPUTE_MAXS);
                AddField cp = new AddField(cw);
                cr.accept(cp,0);
                return cw.toByteArray();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return b;
    }
}