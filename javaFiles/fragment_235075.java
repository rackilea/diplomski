String[] words = "test me".split(" ");
String[] words2 = "you test".split(" ");

int counter = 0;

for (int i = 0; i < words.length; i++) {
    for (int j = 0; j < words2.length; j++) {
        if (words[i].equalsIgnoreCase(words2[j])) {
            counter++;
            System.out.println(words[i]); // prints "test"
        }
    }
}

System.out.println(counter); // prints "1"