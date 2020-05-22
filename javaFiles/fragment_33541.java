public class file {

   public static void main(String[] args) {

       File folder = new File("D:/Users");

        for (File f : folder.listFiles()) 
        {
             if (f.getName().endsWith(".txt")) 
             {
                f.delete(); 
             }
        }
   }
}}