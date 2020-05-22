$ cat Funny.java 
interface Funny {
  public enum AnEnum { One, Two }
  String aField = "";
}

$ javac Funny.java 

$ javap -c Funny.class
Compiled from "Funny.java"
interface Funny extends java.lang.annotation.Annotation {
  public static final java.lang.String aField;

}

$ javap -c Funny\$AnEnum.class | head
Compiled from "Funny.java"
public final class Funny$AnEnum extends java.lang.Enum<Funny$AnEnum> {
  public static final Funny$AnEnum One;

  public static final Funny$AnEnum Two;

  public static Funny$AnEnum[] values();
    Code:
       0: getstatic     #1                  // Field $VALUES:[LFunny$AnEnum;
       3: invokevirtual #2                  // Method "[LFunny$AnEnum;".clone:()Ljava/lang/Object;
...