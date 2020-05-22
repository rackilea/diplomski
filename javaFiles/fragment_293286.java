String toFind = "day";
String sentence = "wolfrevokcatS no snoitseuq krowemoh tsop ot yad enif a si tI";

char[] charArray = sentence.toCharArray();

String reversedSentence = "";

for(int i = 0; i < charArray.length; ++i) {
    reversedSentence += charArray[charArray.length - i - 1];
}

System.out.println(reversedSentence);
boolean matches = reversedSentence.matches(".+" + toFind + ".+");

if(matches) {

    int start = reversedSentence.indexOf(toFind);
    int end = start + toFind.length();

    System.out.println("Before word to find: " + reversedSentence.substring(0, start));
    System.out.println("Word to find: " + reversedSentence.substring(start, end));
    System.out.println("After word to find: " + reversedSentence.substring(end, reversedSentence.length()));
}