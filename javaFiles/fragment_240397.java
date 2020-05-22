package net.bobah.uf4j;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static java.lang.System.out;
import static net.bobah.uf4j.MyTest.MyClassFactory.newMyClass;

public class MyTest {

    @Test
    public void runTest() throws Exception {
        final MyClass ctor = newMyClass("one", "two", "three");
        out.println(Arrays.asList(ctor.str1, ctor.str2, ctor.str3));
        // prints [one, two, three]
    }

    public static class MyClass {
        private final String str1;
        private final String str2;
        private final String str3;

        public MyClass(String str1, String str2, String str3) {
            this.str1 = str1;
            this.str2 = str2;
            this.str3 = str3;
        }

    }

    public static class MyClassFactory {
        private static Unsafe getUnsafe() {
            try {
                Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                return (Unsafe) f.get(null);
            } catch (IllegalAccessException | NoSuchFieldException cause) {
                throw new RuntimeException(cause);
            }
        }

        private static final Unsafe unsafe = getUnsafe();

        private static final List<BiConsumer<MyClass, String>> fieldInitializers = new ArrayList<>();

        static {
            // this can be extended to support one-to-many mappings from args to fields, or to do type transformation on the way
            for (Field field : MyClass.class.getDeclaredFields()) {
                if (String.class.equals(field.getType())) {
                    final long offset = unsafe.objectFieldOffset(field);
                    fieldInitializers.add((obj, val) -> {
                        unsafe.putObject(obj, offset, val);
                    });
                }
            }
        }

        public static MyClass newMyClass(String... args) throws InstantiationException {
            assert args.length == fieldInitializers.size();

            // create uninitialized instance
            final MyClass obj = (MyClass) unsafe.allocateInstance(MyClass.class);

            // inject final fields
            for (int i = 0; i < args.length; ++i) {
                fieldInitializers.get(i).accept(obj, args[i]);
            }

            return obj;
        }
    }

}