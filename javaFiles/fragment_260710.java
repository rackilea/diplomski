boolean empty = true;
while ((readChars = is.read(c)) != -1) {
    for (int i = 0; i < readChars; ++i) {
        if (c[i] == '\n') {
            ++count;
            empty = true;
        } else {
            empty = false;
        }
    }
}
if (!empty) {
    count++;
}
return count;