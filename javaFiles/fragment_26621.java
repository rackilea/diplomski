public class Threading_Sample implements Runnable
 {
    private ArrayList<String> list1;
    ....
    Threading_Sample(String name, ArrayList<String> list1)
    {
        ThreadName=name;
        this.list1 = list1;
    }
  ... 

public static void main (String[] args)
{
     ArrayList<String> List1=new ArrayList<String>();


    Threading_Sample TASK1=new Threading_Sample("THREAD1",list1);
    Threading_Sample TASK2=new Threading_Sample("THREAD2",list1);     

    TASK1.start();
    TASK2.start();
}