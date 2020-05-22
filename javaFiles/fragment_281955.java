import java.io.*;
import java.util.*;


public class HelloWorld{

     public static void main(String []args){
         BigInteger i1 = new BigInteger("4343345345345");
         BigInteger i2 = new BigInteger("4343453345345345");
         BigInteger i3 = new BigInteger("22");

        List<BigInteger> list = new ArrayList<>();

        list.add(i1);
        list.add(i2);
        list.add(i3);


        System.out.println(Collections.min(list, Comparator.naturalOrder()));

     }
}