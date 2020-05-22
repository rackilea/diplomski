for (int i = 0; i < words.length ; i++) {
    if (words[i].length() < shortest.length()){
        shortest = words[i];
        count = "";
    }
    if (words[i].length() == shortest.length()){
        count += words[i] + ", ";
    }
}