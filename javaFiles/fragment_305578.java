public class Outputs
 {
    String bestSol="bestSol";
    String cwsSolution="cwsSolution";

   public void sendToFile(String outFile)
   {

   try 
   {   PrintWriter out = new PrintWriter(outFile);
       out.println("***************************************************");
       out.println("*                      OUTPUTS                    *");
       out.println("***************************************************");
       out.println("\r\n");
       out.println("--------------------------------------------");
       out.println("Clarke & Wright Solution (parallel version)");
       out.println("--------------------------------------------");
       out.println(cwsSolution.toString() + "\r\n");
       out.println("--------------------------------------------");
       out.println("\r\n OUR BEST SOLUTION:\r\n");
       out.println("--------------------------------------------");
       out.println(bestSol.toString() + "\r\n");
       out.close();
   } catch (IOException exception) 
   {   System.out.println("Error processing output file: " + exception);
   }
 }

   public static void main(String[] args) {
        Outputs output = new Outputs();
        output.sendToFile("C:\\t.txt");
   }
}