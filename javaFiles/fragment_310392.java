public class Transpose{
    public static String halfStepUp(String note){
        String n = null;
        if ("c".equals(note)) n = "c#"; //using .equals as a string comparison
        if ("d".equals(note)) n = "d#"; //not "d"#
        return n;
    }   
}