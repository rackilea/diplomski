public class MyClass {
  public static void main(String args[]) {
    int end=4;
    int i,j,num=1;
    for(i=0;i<end;i++)
    {
        for(j=0;j<=i;j++)
        {
            System.out.print(num+ " ");
            num++;
        }
        System.out.println();
    }
    for(i = end; i >= 1; --i) 
    {
        num-=i;
        for(j = 1; j <= i; ++j) 
        {
            System.out.print(num + " ");
            num++;
        }
        num-=i;
        System.out.println();
    }   
  } 
}