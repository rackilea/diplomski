String words = "word, word word word";
String newWords

int space1 = words.indexOf(" ");

newWords = words.substring(0, space1) & "." & words.substring(space1 + 1);

int lastSpace = newWords.lastIndexOf(" ");

newWords = newWords.subString(0, lastSpace) & "." & newWords.subString(lastSpace + 1);