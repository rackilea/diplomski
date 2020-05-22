String text = "helloo";
int length = text.length();
outerloop:
for (int i = 0; i <= length - 1; i++) {
    char curChar = text.charAt(i);
    for (int j = i + 1; j <= length - 1; j++) {
        if (curChar == text.charAt(j)) {
            System.out.println(curChar);
            break outerloop;
        }
    }
}