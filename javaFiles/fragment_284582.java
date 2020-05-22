import java.lang.reflect.Method;

class EnumReflection
{

  public static void main(String[] args)
    throws Exception
  {
    Class<?> clz = Class.forName("test.PropertyEnum");
    /* Use method added in Java 1.5. */
    Object[] consts = clz.getEnumConstants();
    /* Enum constants are in order of declaration. */
    Class<?> sub = consts[0].getClass();
    Method mth = sub.getDeclaredMethod("getDefaultValue");
    String val = (String) mth.invoke(consts[0]);
    /* Prove it worked. */
    System.out.println("getDefaultValue " + 
      val.equals(PropertyEnum.SYSTEM_PROPERTY_ONE.getDefaultValue()));
  }

}