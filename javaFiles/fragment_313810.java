public class RearrangeName{
    public static void main(String[] args){
         Scanner keyboard = new Scanner(System.in);
         System.out.println ("Enter your name");
         String inputStr= keyboard.nextLine();
         System.out.println(lastFirst(inputStr));
    }
    public static String lastFirst (String str){
        String middleAndLast = str.substring(str.indexOf(" ")+ 1);
        String last = middleAndLast.substring(middleAndLast.indexOf(" ") + 1);
        String first = str.substring(0, str.indexOf(" "));
        String middle = middleAndLast.substring(0, middleAndLast.indexOf(" "));
        char middleInitial = middle.charAt(0);
        return("\"" + last + ", " + first + ", " + middleInitial + "\"");
    }
}