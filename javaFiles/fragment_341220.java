public static void main (String[] args)
{
    String sample = "Will you come,yes/no";
    StringTokenizer tr = new StringTokenizer(sample.replace(" ",",").replace("/",",/,"),",");
    while (tr.hasMoreElements())
        System.out.println(tr.nextElement() + ",");
}