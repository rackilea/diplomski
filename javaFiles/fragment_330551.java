import java.lang.reflect.Field;
import sun.misc.Unsafe; 
public class Direct {

        public static void main(String... args) {
            Unsafe unsafe = null;

            try {
                Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                unsafe = (sun.misc.Unsafe) field.get(null);
            } catch (Exception e) {
                throw new AssertionError(e);
            }

            long value = 12345;
            byte size = 1;
            long allocateMemory = unsafe.allocateMemory(size);
            unsafe.putAddress(allocateMemory, value);
            long readValue = unsafe.getAddress(allocateMemory);
            System.out.println("read value : " + readValue);
        }
    }