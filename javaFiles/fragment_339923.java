public class file_interface {
    BufferedWriter wr;
    public file_interface() {
         wr = new BufferedWriter(new FileWriter("target.txt"));
    }
}