String[] list = { "a", "b", "c", "d", "e" };

for (int pos = 0; pos < list.length; pos++) {
    String[] tmpCopy = list.clone();
    moveLastup(tmpCopy, pos);
    showList(tmpCopy);
}