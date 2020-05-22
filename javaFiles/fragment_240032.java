public static String vowelHarmony(String input) {
    String result = "you screwed something up";

    if (hasHighVowel(input)) {
        result = "high";
    }
    if (hasLowVowel(input)) {
        result = "deep";
    }
    if (hasHighVowel(input) && hasLowVowel(input)) {
        result = "mixed";
    }

    return result;
}