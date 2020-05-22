import java.util.*;
import java.io.*;

class Uke63{
    public static void main(String[]args){

    char c='t';
        String tekst="Jabba the Hutt var en stygg fyr";

    System.out.println(forekommer(c, tekst));

    }

    static boolean forekommer(char c, String tekst){

    boolean retval=tekst.contains(c);
    return retval;
    }
}