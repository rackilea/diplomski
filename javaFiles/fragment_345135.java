String[] words = { "one", "two", "three", "four", "five", "six", "seven",
    "eight", "nine", "ten" };
String phrase = "I won 7 of the 10 games and received 30 dollars.";

for (int i = 1; i <= 10; i++) {
  String pattern = "(^|\\D)" + i + "(\\D|$)";
  phrase = phrase.replaceAll(pattern, "$1" + words[i - 1] + "$2");
}

System.out.println(phrase);