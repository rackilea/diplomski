import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

public class RServeTest {

    static RConnection rcon;

    public static void main(String[] args) {
        try {

            String fileName = "sample.R";
            // Note: Change filename for testing different samples

            String filePath = "/filepath/";

            try {
                rcon = new RConnection();
            }
            catch(Exception e){
                System.out.println("Error Connecting: "+e);
            }

            String rCode = "source(\""+filePath+fileName+"\")";
            System.out.println("Rscript call on file: "+rCode);

            // Source file
            REXP r0 = rcon.parseAndEval("try(eval(parse(text="+rCode+")),silent=TRUE)");

            // Run main() function
            REXP r = rcon.parseAndEval("try(eval(parse(text=main())),silent=TRUE)");


            System.out.println("\n---------  with try error ------------");

            if (r.inherits("try-error")) 
                System.out.println("Error: "+r.asString());
            else 
                System.out.println("Executed R code successfully."+"r object: "+r.asString());

            System.out.println("\n---------  without try error ------------");

            System.out.println("R output :"+rcon.eval("main()").asString());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}