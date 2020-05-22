public class Main{
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6},temp=0;
        int x=5;//test number
        for(int i=0;i<a.length;i++) {
            if (a[i]==x) {  
                temp=a[i];
                for(int j=i;j>0;j--)
                    a[j]=a[j-1];
                break;
            }
        }
        a[0]=temp;

        //Let's test the logic
        for(int n:a)
            System.out.print(n+"\t");
    }
}