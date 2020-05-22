import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()), i;
        while(t-->0)
        {
            int n = Integer.parseInt(sc.nextLine());
            StringBuilder str = new StringBuilder("");
            String a = sc.nextLine();
            for(i=1;i<n;i+=2)
                str.append(a.substring(i,i+1));
            i=n-1;
            if(n%2==0)
                i--;
            for(;i>=0;i-=2)
                str.append(a.substring(i,i+1));
            System.out.println(str);
        }
    }
}