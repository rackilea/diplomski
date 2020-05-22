import javax.swing.JOptionPane;

public class MyAutoItFoo {
   public static void main(String[] args) {
      long heapSize = Runtime.getRuntime().totalMemory();
      long heapMaxSize = Runtime.getRuntime().maxMemory();
      String heapString = String.format("Heap Size = %H; Max Heap = %H", 
            heapSize, heapMaxSize);
      System.out.println(heapString);
      JOptionPane.showMessageDialog(null, heapString);
   }
}