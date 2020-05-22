public class Main {

    public static void main(String [] args)
    {
        String str="[one][two][three]";
        String delimiter="\\s+|]\\s*|\\[\\s*";
        String [] arr=str.split(delimiter);
        for(String a:arr)
            System.out.print(a);

    }
}