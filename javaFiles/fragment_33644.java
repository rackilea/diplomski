import java.lang.reflect.Constructor;

import sun.reflect.ReflectionFactory;

public class AnotherParadoxTest
{
    public static void main(String[] args) throws Exception
    {
        ReflectionFactory rf = ReflectionFactory.getReflectionFactory();
        Constructor<?> declaredConstructor = 
            Object.class.getDeclaredConstructor();
        Constructor<?> constructor = rf.newConstructorForSerialization(
            Paradox.class, declaredConstructor);
        Paradox paradox = (Paradox) constructor.newInstance();
        System.out.println("This is paradox: "+paradox);
    }

}