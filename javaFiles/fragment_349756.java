String string = "the colored port should be black or white or brown";
String[] words = string.split(" ");
String word = "or";
int occurrences = 0;
for (int i=0; i<words.length; i++)
    if (words[i].equals(word))
        occurrences++;
System.out.println(occurrences);