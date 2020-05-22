import java.io.*;

   public class GetWindowsEditionTest
   {
      public static void main(String[] args)
      {
         Runtime rt; 
         Process pr; 
         BufferedReader in;
         String line = "";
         String sysInfo = "";
         String edition = "";
         String fullOSName = "";
         final String   SEARCH_TERM = "OS Name:";
         final String[] EDITIONS = { "Basic", "Home", 
                                     "Professional", "Enterprise" };

         try
         {
            rt = Runtime.getRuntime();
            pr = rt.exec("SYSTEMINFO");
            in = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            //add all the lines into a variable
            while((line=in.readLine()) != null)
            {
               if(line.contains(SEARCH_TERM)) //found the OS you are using
               {
                //extract the full os name
                  fullOSName = line.substring(line.lastIndexOf(SEARCH_TERM) 
                  + SEARCH_TERM.length(), line.length()-1);
                  break;
               } 
            }

            //extract the edition of windows you are using
            for(String s : EDITIONS)
            {
               if(fullOSName.trim().contains(s))
               {
                  edition = s;
               }
            }

            System.out.println("The edition of Windows you are using is " 
                               + edition); 

         }
            catch(IOException ioe)      
            {   
               System.err.println(ioe.getMessage());
            }
      }
   }