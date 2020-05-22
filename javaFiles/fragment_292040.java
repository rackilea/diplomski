public class Hello
    {
      public static void main(String[] args){
        String a = "steve";
        String b = "Andrew";
        String firstletter = a.substring(0,1);
        String remainder = a.substring(1);
        String capitalized = firstletter.toUpperCase() + remainder.toLowerCase();

        System.out.print("Hello " + capitalized + " " + b + "s" );

    }
}