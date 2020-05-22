int countOfLetters = 0 ;
String sentence = "Once upon a time..." ;
sentence = sentence.toLowerCase();
int[] countOfAlphabets = new int[26];
for (int i = 0; i < sentence.length(); i++) {
    if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
        countOfAlphabets[sentence.charAt(i) - 97]++;
        countOfLetters++;
    }
}