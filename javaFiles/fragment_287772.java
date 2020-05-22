public class CommandPrompt {
    public static final String prompt = System.getProperty("user.name")+">";

    public static void main(String[] args) {
      System.out.println(prompt);
    }
}