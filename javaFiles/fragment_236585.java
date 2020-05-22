public class Test {
public static void main(String args[])
{
    String[] s={"0010", "0110", "1010", "1110", "0001", "0011"};
    for(int i=0;i<s.length;i++)
    {
        for(int j=i+1;j<s.length;j++)
        {
            if(isPair(s[i].toCharArray(), s[j].toCharArray()))
            {
                System.out.println("{\""+s[i] + "\",\"" + s[j]+"\"}");
            }
        }
    }
}
public static boolean isPair(char[] a, char[] b)
{
    int count = 0;
    if(a.length == b.length)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]!=b[i])
                count++;
        }
    }
    return count == 1 ? true : false;
}
}