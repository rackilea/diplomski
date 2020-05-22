private void check() {
    SigmaLog.d("first line\n" + "second line");
    String receiveString = "";
    String newString = "first line";
    int i = 0;
    while (i < 2) {
        receiveString += newString + "\n";
        newString = "second line";
        i++;
    }
    SigmaLog.d(receiveString);
}