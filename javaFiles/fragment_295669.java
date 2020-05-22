public class Main {
    public static void main(String[] args) {
        String text = "a \"b c d\" e \"f g\" h";
        System.out.println("text = " + text + "\n");
        for(String t : text.split("[ ]+(?=([^\"]*\"[^\"]*\")*[^\"]*$)")) {
            System.out.println(t);
        }
    }
}