StringBuilder sb = new StringBuilder(inputString);
for (int i = sb.length() - 1; i >= 0; i--) {
    if (Character.isDigit(sb.charAt(i)))
        break;
    sb.setCharAt(i, ' ');
}
String output = sb.toString();