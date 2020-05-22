int strLength = str.length(); // so you don't have to call this method every time

for (int i = 0; i < strLength; i++) {
    char ch = str.charAt(i); // so you won't have to call this twice
    if (ch == '(') {
        counter++;
    } else if (ch == ')') {
        counter--;
        if (counter < 0) {
            return false;
        }
    }
}