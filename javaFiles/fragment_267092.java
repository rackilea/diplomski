public class Project {
   public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No parameters. Please give me something to print!!");
        } else {
            for (String parameter : args) {
                System.out.println(parameter);
            }
        }
    }
}