String str = "...:...:If...Then...:...:Else...:...:...:IfEnd:...";
String[] toks = str.replaceAll("(\\bIf\\b.*?\\bIfEnd\\b):?|:", "$1\n").split("\\n+");

for (String tok: toks) {
    System.err.printf("%s%n", tok);
}