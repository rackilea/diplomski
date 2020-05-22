public class PrintLines {
    public static void main(String[] args) {
        java.io.File file;
        java.io.PrintWriter output = null;
        try{
            file = new java.io.File("myFile.txt");
            output = new java.io.PrintWriter(file);
            int count = 1;
            while (count <= 300) {
                output.println(count + " I love Java!");
                count++;

           }
           output.close();
       } catch(*EXCEPTION*) {
       //Handle Exception
       } finally {
          if(output!=null) {
           output.close();
          }
       }
    }
}