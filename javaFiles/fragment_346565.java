import java.lang.reflect.*;
import java.util.*;

public class ArrayTest
{ 
  public static void main(String[] args)
  {
    evaluate("Hello");
    evaluate(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
    evaluate(new int[]{0, 1, 2});
    evaluate(null);
  }

  public static void evaluate(Object object)
  {
    List<String> primitiveArrayTypes = Arrays.asList(new String[] {
        "boolean[]", "byte[]", "char[]", "double[]",
        "float[]", "int[]", "long[]", "short[]"
    });

    if (object == null)
    {
      System.out.println("Null object.");
      return;
    }

    Class objClass = object.getClass();

    if (objClass.isArray())
    {
      if (primitiveArrayTypes.contains(objClass.getCanonicalName()))
      {
        System.out.println("Contents of primitive array:");
        for (int i = 0; i < Array.getLength(object); i++)
        {
          System.out.println(Array.get(object, i));
        }
      }
      else
      {
        System.out.println("Contents of Object array:");
        for (Object obj : (Object[]) object)  // cast should now always work
        {
          System.out.println(obj);
        }
      }
    }
    else
    {
      System.out.println("Not an array: " + object);
    }
    System.out.println("---");
  }
}