// this class simulates a pipe between two processes
public class PipeClass implements Runnable {
    // the input stream
    InputStream is;
    // the output stream
    OutputStream os;
    // the name associated with the input stream (for printing purposes only...)
    String isName;

    // constructor
    public PipeClass(InputStream is, OutputStream os, String isName) {
        this.is = is;
        this.os = os;
        this.isName = isName;
    }

    @Override
    public void run() {
        try {
            // use a byte array output stream so we can clone the data and use it multiple times
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            // read the data into the output stream (it has to fit in memory for this to work...)
            byte[] buffer = new byte[512]; // Adjust if you want
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // clone it so we can print it out
            InputStream clonedIs1 = new ByteArrayInputStream(baos.toByteArray());
            Scanner sc = new Scanner(clonedIs1);

            // print the info
            while (sc.hasNextLine()) {
                System.out.println(this.isName + " >> " + sc.nextLine());
            }

            // clone again to redirect to the output of the other process
            InputStream clonedIs2 = new ByteArrayInputStream(baos.toByteArray());
            buffer = new byte[512]; // Adjust if you want
            while ((bytesRead = clonedIs2.read(buffer)) != -1) {
                // write it out to the output stream
                os.write(buffer, 0, bytesRead);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                // close so the process will finish
                is.close();
                os.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}