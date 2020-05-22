import java.lang.reflect.Constructor;

import sun.misc.Unsafe;

public class ParadoxTest
{
    public static void main(String[] args) throws Exception
    {
        Constructor<Unsafe> unsafeConstructor = 
            Unsafe.class.getDeclaredConstructor();
        unsafeConstructor.setAccessible(true);
        Unsafe unsafe = unsafeConstructor.newInstance();
        Paradox paradox = (Paradox) unsafe.allocateInstance(Paradox.class);
        System.out.println("This is paradox: "+paradox);
    }
}