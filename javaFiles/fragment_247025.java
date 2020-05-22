import java.io.* ;
import java.nio.file.*;

public class FilePrepender // class name 
{
    public static void main (String [] args)
    {
        // make a giant dump file which we will append all read files into  
        try {
            new File("Output/").mkdirs();
            File megaDumpFile = new File("Output/masterDump.txt");

            if (megaDumpFile.createNewFile()) {
                System.out.println("File creation success");
            } else {
                System.out.println("File was not made. File already exists. Please delete");
            }

        } catch (IOException e) {

        }

        //grab file names 
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                listOfFiles[i].getName();
            } else if (listOfFiles[i].isDirectory()) {
                //do nothing
            }
        }

        //open files + duplicate + prepend + and append product to end of master dump file 
        // main for 
        for (int j = 0; j < listOfFiles.length; j++){
            //append file name for mega dump file 
            String fileNameTemp = listOfFiles[j].getName();  // get file name
            if (!fileNameTemp.toLowerCase().endsWith(".txt")) {
                continue;
            } 

            // duplicate input files 
            FileInputStream instream = null;
            FileOutputStream outstream = null;

            try {
                File infile =new File(""+listOfFiles[j].getName());
                File outfile =new File("Output/"+listOfFiles[j].getName());

                instream = new FileInputStream(infile);


                byte[] buffer = new byte[1024];

                int length;

                // apend file name into the new file 
                // String fileNameTemp = listOfFiles[j].getName();  // get file name 
                outstream = new FileOutputStream(outfile);
                PrintWriter out = new PrintWriter(outstream);
                out.println(">"+fileNameTemp);
                out.flush();
                out.close();

                // now copy contents of previous file into the new file 

                /*copying the contents from input stream to
                * output stream using read and write methods
                */
                outstream = new FileOutputStream(outfile, true);
                while ((length = instream.read(buffer)) > 0){
                    outstream.write(buffer, 0, length);
                }
                //Closing the input/output file streams
                instream.close();
                outstream.close();

                // file is copied 
            } catch(IOException ioe) { 

            }

            // copy newly copied file into mega dump 
            try {
                File infile =new File("Output/"+listOfFiles[j]); // newly copied 
                File outfile =new File("Output/masterDump.txt");

                instream = new FileInputStream(infile);
                outstream = new FileOutputStream(outfile, true);

                byte[] buffer = new byte[1024];

                int length;
                /*copying the contents from input stream to
                * output stream using read and write methods
                */
                while ((length = instream.read(buffer)) > 0){
                    outstream.write(buffer, 0, length);
                }

                //Closing the input/output file streams
                instream.close();
                outstream.close();

                // file is copied 

            } catch(IOException ioe) {

            }

        } // end for loop 
    } // end main 
} // end class