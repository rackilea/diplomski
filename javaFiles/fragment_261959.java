public static String separatingWords(String str) {
    String[] words = str.split(" ");
    String result = "";  // Defaulted the result

    for (int i = 0; i < words.length-1; i++) {
        result += words[i] + "-";  // Added a +=
    }
    result += words[words.length - 1];
    return result;
}