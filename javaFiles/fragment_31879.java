public class EmployeeData {
  // constants should be declared static and final, and not inside main
  private static final String FILE = "employees.txt";

  // If you have an exception and you don't know how to handle it the best thing
  // to do is throw it higher and let the caller of your method decide what to do.
  // If there's *nothing* you want to do with an exception allow main() to throw
  // it as you do here; your program will crash, but that's a good thing!
  public static void main(String[] args) throws IOException {
    // Notice the <> after ArrayList - without it you're defining a "raw type"
    // which is bad - https://stackoverflow.com/q/2770321/113632
    ArrayList<Employee> emp2014 = new ArrayList<>();
    ArrayList<Employee> emp2015 = new ArrayList<>();

    // A try-with-resources block automatically closes the file once you exit the block
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    try (Scanner scan = new Scanner(new BufferedReader(new FileReader(FILE)))) {
      while (scan.hasNextLine()) {
        String l = scan.nextLine();
        String[] token = l.split("\t");
        // The code below this line assumes that token has at least five indicies;
        // since that isn't always true you need to handle that edge case before
        // accessing the array indicies directly.
        String year = token[0];
        String type = token[1];
        String name = token[2];
        String monthly = token[3];
        String bonus = token[4];
        System.out.println(year + " " + type + " " + name + " " + monthly + " " + bonus);
      }
    }
  }
}