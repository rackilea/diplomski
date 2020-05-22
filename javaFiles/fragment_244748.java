public class MyThread extends Thread
{
    public int myarg;
    public void run()
    {
    }
}

public void useThread(int inputArgs[])
{
    ArrayList<MyThread> threadArray = new ArrayList<MyThread>();
    for (int arg : inputArgs)
    {
        MyThread temp = new MyThread(arg);
        temp.start();
        threadArray.add(temp);            
    }
    for (MyThread t : threadArray)
        System.out.println(t.myarg);

}