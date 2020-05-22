public static String subStringBetween(String text, String after, String before) {
    Pattern pattern = Pattern.compile("(?<=\\s|^)"+after +"\\s(.*?)\\s+"+ before);
    Matcher matcher = pattern.matcher(text);

    while (matcher.find()) {
        return matcher.group(1);
    }
    return ""; //or null or whatever you need

}

Input: Play a Nice Rock Song 
After: a 
Before: Song
Output: Nice Rock

Input: play a rock song xxx
After: a 
Before: song
Output: rock

Input: a Play Nice Rock Song
After: a 
Before: Song
Output: Play Nice Rock

Input: aaaa bbbb a bbb aaa b aaaa bbb
After: a 
Before: b
Output: bbb aaa