//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.math.BigDecimal;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;

public class NumTest implements GroovyObject {
    public NumTest() {
        MetaClass var1 = this.$getStaticMetaClass();
        this.metaClass = var1;
    }

    public static void main(String... args) {
        test(BigDecimal.valueOf((long)20));
        Object var10000 = null;
    }

    public static void test(BigDecimal number) {
        DefaultGroovyMethods.println(NumTest.class, number);
        Object var10000 = null;
    }
}