import java.util.*;
import java.io.*;

class Ideone
{
    public static class LinkTypeToken<T> extends TypeToken<List<T>> {}
    public static class TypeToken<T> {}
    public static void main (String[] args) throws java.lang.Exception  {            
        LinkTypeToken<Number> listA = null;
        TypeToken<List<Number>> listB = listA;

        LinkTypeToken<? extends Number> listC = null;
        TypeToken<? extends List<? extends Number>> listD = listC;

        // error: incompatible types: LinkTypeToken<CAP#1> cannot be 
        // converted to TypeToken<List<? extends Number>>
        // TypeToken<List<? extends Number>> listE = listC;
        //                                           ^
        // where CAP#1 is a fresh type-variable:
        //   CAP#1 extends Number from capture of ? extends Number        
        TypeToken<List<? extends Number>> listE = listC;
    }
}