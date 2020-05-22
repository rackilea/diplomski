String sentence = "J9581 TAMAN MERLIMAU, JALAN MUAR, MERLIMAU, MELAKA,77300,MERLIMAU";
String stringToReplace = "MERLIMAU";
int index = 0;
int occurrences = 0;
while ((index = sentence.indexOf(stringToReplace, index)) != -1) {
    ++occurrences;
    if (occurrences == 3) {
        sentence = sentence.substring(0, index) + sentence.substring(index + stringToReplace.length());
        break;
    }
    index += stringToReplace.length();
}

// Add this condition to remove the comma at the end if it exists:
if (",".equals(sentence.substring(sentence.length() - 1))) {
    sentence = sentence.substring(0, sentence.length() - 1);
}