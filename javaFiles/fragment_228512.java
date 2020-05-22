public static void main(String[] args){
  List<String> allowed = Arrays.asList("apple", "orange", "potato");
  String input = "There is apple and orange";
  System.out.println(isValid(input, allowed));
}

boolean isValid(String input, List<String> allowed){
  String[] words = input.split("\\s+");
  for(String word:words){
    if(!allowed.contains(word)){
      return false;
    }
  }
  return true;
}