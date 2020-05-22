final int LINE_LENGTH = 40;

String word1 = ...;
String word2 = ...;

StringBuilder sb = new StringBuilder(LINE_LENGTH);
sb.append(word1);
for (int i = 0; i + word1.length() + word2.length() < LINE_LENGTH; i++) {
    sb.append(".");
}
sb.append(word2);

System.out.println(sb.toString());