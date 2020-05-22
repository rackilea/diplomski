public class FlushPrintWriter {

    public static void main(String[] args) throws IOException  {
        FileReader fileIn = new FileReader("in.txt");
        FileWriter out = new FileWriter("out.txt");
        PrintWriter pw = new PrintWriter(out);
        int c;        
        while ((c = fileIn.read()) != -1) {
            if(c!=59) {
               pw.print((char)c);
            } else {
               pw.println();
            }
        }
        pw.flush();
    }
}