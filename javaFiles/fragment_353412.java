public static String[] wordsWithout(String[] words, String target) {
    int numberOfTargets = 0;

    for (int i = 0; i < words.length; i++){
        if ( words[i].equals(target) ) numberOfTargets++;
    }

    String[] result = new String[words.length - numberOfTargets];
    int j =0; // for indices of result
    for (int i = 0; i < words.length; i++){
        if (!words[i].equals(target) ){          
            result[j++] = words[i];
        } 
    }
    return result;
}