public class FileWriterExample {
    public static void main(String args[]) {
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("C://Users//Desktop//random.txt"));

            for (int i = 1; i < 1001; i++) {
                fileout.println(i);
            }
            fileout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}