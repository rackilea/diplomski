String sentence = "I want to walk in the park with my father";

String[] words = sentence.split(" ");
List<String> threeWords = new ArrayList<>();

int length = words.length;
for (int ind = 2; ind < length; ind += 3) {
    threeWords.add(words[ind - 2] + " " + words[ind - 1] + " " + words[ind]);
}

if (length % 3 == 1) {
    threeWords.add(words[length - 1]);
} else if (length % 3 == 2) {
    threeWords.add(words[length - 2] + " " + words[length - 1]);
}