public class LargeInteger {

    private int[] intArray;
    //convert the strings to array
    public LargeInteger(String s) {
        intArray = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            intArray[i] = Character.digit(s.charAt(i), 10); // in base 10
        }
    }

    //display the strings
    public String display() {           
          String result="";

          for (int i = 0; i < intArray.length; i++) {     
            result += intArray[i];
          }
          return result.toString();
        }   
}