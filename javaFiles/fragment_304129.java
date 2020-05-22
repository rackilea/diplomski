String input = s.nextLine();
String result = "";
for(String word : input .split(" ")) {
    if(isPalindrome(word))
        result += word + " ";
}