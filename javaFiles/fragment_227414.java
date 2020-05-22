//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import groovy.lang.Binding;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class Animal_script extends Script {
    public Animal_script() {
        CallSite[] var1 = $getCallSiteArray();
    }

    public Animal_script(Binding context) {
        CallSite[] var2 = $getCallSiteArray();
        super(context);
    }

    public static void main(String... args) {
        CallSite[] var1 = $getCallSiteArray();
        var1[0].call(InvokerHelper.class, Animal_script.class, args);
    }

    public Object run() {
        CallSite[] var1 = $getCallSiteArray();
        Object animal1 = var1[1].callConstructor(Animal.class, "Fluffy", 4);
        Object animal2 = var1[2].callConstructor(Animal.class, "Fluffy", 4);
        Object animal3 = var1[3].callConstructor(Animal.class, "Snoopy", 4);
        return var1[4].callCurrent(this, ScriptBytecodeAdapter.compareEqual(animal1, animal1));
    }
}