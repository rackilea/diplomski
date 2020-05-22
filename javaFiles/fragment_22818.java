public class YourDesiredClassname implements Type {

    public static Type match(String string) {
        try {
            return TypeBuiltIn.valueOf(string.toUpperCase());
        } 
        catch (Exception e) {
            return null;
        }
    }   
}