import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s="anupam+singh"; /* here the string is composed of three parts*/
        String s1="anupam"; /*this is the first part of the string, in your case it is **retrieved name***/

        if(s.substring(0,s.indexOf("+")).equals(s1)) /*we use a substring function of String class, it takes two arguements starting and end index and returns the substring from the given string, the end index is exclusive*/
        {
            String s2=s.substring(s.indexOf("+")+1); /*the substring function can work on one arguement even, if you just give the starting index then it will return the substring from that starting index till the end of string */
            System.out.println(s2);
        }


    }
}