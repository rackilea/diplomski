public class ProcessInput {
    String line = ""; // outside the paste method, in the class
    public void paste(String feedback) {
        line += feedback;
        System.out.println(line);
    }
}