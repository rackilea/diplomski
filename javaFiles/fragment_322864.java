public class ClassifiedType
{
  public enum ClassifiedTypeType { INTEGER,  FLOAT,  STRING,  BOOLEAN };

  ClassifiedTypeType  typeType = null;
  int                 integerValue;
  float               floatValue;
  String              stringValue;
  boolean             booleanValue;

  public ClassifiedType(int i) { integerValue = i; typeType = ClassifiedTypeType.INTEGER; }
  public ClassifiedType(float f) { floatValue = f; typeType = ClassifiedTypeType.FLOAT; }
  // etc.

  public int getIntegerValue()
  {
    if (typeType != ClassifiedTypeType.INTEGER) 
    { 
      throw new IllegalArgumentException("Attempting getInteger on type of " + this.toString());
    }
    else
    {
      return integerValue;
    }
  }

  // do gets for other types similarly.

  public static ClassifiedType getClassifiedType(String string)
  {
    // parse the string, determine which type you want, 
    // instantiate a ClassifiedType with its value and 
    // and type, and return it.
  }
}