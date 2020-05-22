import java.util.*;
class Sequence
{
    public static ArrayList<String> foo(int n)
    {
        if(n==1)
        {
            ArrayList<String> a = new ArrayList<String>();
            a.add("1");
            return a;
        }
        ArrayList<String> withOutN = foo(n-1);
        ArrayList<String> out = new ArrayList<String>();

        Iterator<String> it = withOutN.iterator();
        Integer i = new Integer(n);
        while(it.hasNext())
        {
            String s = it.next();
            out.add(s);
            s = s.concat("," + i.toString());
            out.add(s);
        }
        out.add(i.toString());
        return out;
    }

    public static void main(String[] args)
    {
        int n=4;
        ArrayList<String> out = new ArrayList<String>();

        out = (ArrayList<String>) foo(n);

        Iterator<String> it = out.iterator();
        while(it.hasNext())
        {
            System.out.println(( it.next()) );
        }
    }
}