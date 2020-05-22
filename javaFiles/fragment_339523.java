public class Main {

   public static void main(String[] args) throws Exception {
      Object[] gnode = new Object[10];
      Arrays.stream(gnode).parallel().forEach(Main::processOneNode);
   }

   public static void processOneNode(Object node){
       System.out.println(Thread.currentThread().getName());
   }
}