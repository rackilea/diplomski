public class Demo 
{
    public static void main(String[] args)
    {
        Demo instance = new Demo();
        instance.init();
    }
    public void init() 
    {
        int size = 0;
        size = inc(size);
        System.out.println(size);
    }
    public int inc(int size)
    {
        size++;
        return size;
    }
}