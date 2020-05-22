package packagechain;

public class MainProgram {

  public static void main(String[] args) {

      Text m;
      String s;
      try {
         m = new Text();
         while(m.hasLine) {
            s = m.nexline();
            //EXAMPLE: for each line, print a substring starting from its third character
            if(s != null) System.out.println(s.substring(2));
            //Here I edit in future these Line , so it's important that i get line by line from my other class, becaus I Have to edit each line itself!
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found!");
    } 

    }
}