import java.util.*;

  public class JavaFiddle
  {
    public static void main(String[] args)
    {
      // starting here with the result of your regex operation
      String[] yourOutputArray = {"(z", "/", "(2+t))", "/", "((2.0+var)", "*", "(x/y))"};

      List<String> listy = new ArrayList<String>();
      String s = "";
      for(int i = 0; i < yourOutputArray.length; i++){
          s += yourOutputArray[i];

          if(characterCount(s,"(") > 0 && characterCount(s,"(") == characterCount(s,")")){
              listy.add(s);
              s = "";
          }else if(s.length() > 0 && characterCount(s,"(") == 0){
              // this must be an operator we want to split on
              listy.add(s);
              s = "";
          }
      }

      // listy is the result you are looking for
      System.out.println(listy); // [(z/(2+t)), /, ((2.0+var)*(x/y))]
    }

    public static int characterCount(String input, String character){
        return input.length() - input.replace(character, "").length();
    }
  }