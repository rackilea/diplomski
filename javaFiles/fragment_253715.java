//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.math.BigDecimal;
import org.codehaus.groovy.runtime.callsite.CallSite;

public class NumTest implements GroovyObject {
    public NumTest() {
        CallSite[] var1 = $getCallSiteArray();
        MetaClass var2 = this.$getStaticMetaClass();
        this.metaClass = var2;
    }

    public static void main(String... args) {
        CallSite[] var1 = $getCallSiteArray();
        var1[0].callStatic(NumTest.class, Integer.valueOf(20));
    }

    public static void test(BigDecimal number) {
        CallSite[] var1 = $getCallSiteArray();
        var1[1].callStatic(NumTest.class, number);
    }
}