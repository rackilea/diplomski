class Main
{
 public static void main(String args[]) throws IOException
 {
  Model model = new Model();
  View view = new View();
  Controller controller = new Controller(view, model);
 }
}