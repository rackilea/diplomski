import java.util.*;

public class NumFormEx
{
    public static ArrayList <String> listIt (String... params) 
    {
        ArrayList <String> as = new ArrayList <String> ();
        for (String s: params)
            as.add (s);
        return as;
    }

    public static void main (String args[])
    {
        Map <Integer, ArrayList<String>> mils = new HashMap<Integer, ArrayList<String>> ();
        mils.put (1, listIt ("foo", "bar")); 
        mils.put (2, listIt ("zacka", "zacka")); 
        System.out.println ("mils:\t" + mils);
        mils.put (1, listIt ("foobar"));        
        System.out.println ("mils:\t" + mils);
    }
}