public class Main
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> al1 = new ArrayList<String>();
        al1.add("a");
        al1.add("b");
        ArrayList<String> al2 = new ArrayList<String>();
        al2.add("1");
        al2.add("2");

        ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
        al.add(al1);
        al.add(al2);

        System.out.println(al);
        System.out.println( al.toString().replace("[", "").replace("]", "") );
    }
}