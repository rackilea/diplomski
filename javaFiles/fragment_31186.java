public class MemoryLeakTest {
     int number=0;
     public MemoryLeakTest mobj;

     MemoryLeakTest(int num){
        number = num;
     }

     protected void finalize(){
        System.out.println(number + " released.");
     }

    public static void main(String[] args) {
        try{
             System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
             System.out.println("Free Memory in starting "+ Runtime.getRuntime().freeMemory());
             MemoryLeakTest first = new MemoryLeakTest(0);  // Keep a reference to one of them
             MemoryLeakTest current = first;
             for(int i = 1; i < Int.Parse(args[0]); i++) // forgive me, Java's been a while.  This may be C#.  But parse the first arg for your number of objects
             {
                 current.mobj = new MemoryLeakTest(i);
                 current = current.mobj;
             }
             System.out.println("Free Memory in end "+ Runtime.getRuntime().freeMemory());
             System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
        }
        catch(Exception exp){}
        finally{
            System.out.println("Free Memory"+ Runtime.getRuntime().freeMemory());
            System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
        }
    }

}