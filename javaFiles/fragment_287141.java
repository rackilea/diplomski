public class RecursionPracticeProgram {
  public void run() {
    String input = reader.readLine("String: ");
    KeyboardReader reader = new KeyboardReader();
    System.out.println(reader.backstring(input));
  }

  public String backString(String s){
    if(s.length()==0)
        return s;
    System.out.println(backString(s.substring(1)) + s.charAt(0));   
    return backString(s.substring(1)) + s.charAt(0);
  }
}