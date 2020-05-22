package recipeNo057;

import com.sun.jna.Library;
import com.sun.jna.WString;
import com.sun.jna.Native;
import com.sun.jna.Structure;

@Structure.FieldOrder({ "field" })
public class Data extends Structure {

    public static class ByValue extends Data implements Structure.ByValue { }
    public static class ByReference extends Data implements Structure.ByReference { }
    public volatile int field;

}