String input = s.nextLine();
List<String> words = new ArrayList<>();
for(String word : input .split(" ")) {
    if(isPalindrome(word))
        list.add(word);
}