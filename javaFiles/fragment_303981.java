public class Tester
{
    public static void main(String args[])
    {
        char ch[] = new char[91];
        for(char a =65;a<ch.length;a++)
        {
            ch[a] = a;
        }
        for(char a= 65;a<ch.length;a++)  // char
        {
            char c = ch[a];            //a
            System.out.print(c+", ");
        }
    }
}