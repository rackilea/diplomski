public class IdentityCrisis
{

  public static void main( String[] args )
  {
    String dilemma = "I know you want me to be something I don't want to be unless you prove me it is OK";

    System.out.println(
       dilemma.replaceAll("I", "y-o-u")
              .replaceAll("you", "I")
              .replaceAll("y-o-u", "you")
    );        
  }

}