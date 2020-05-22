// searches all lines for first line index containing `filter`
static int getLineNumberWithFilter(String filter) {
    int n = 0;
    for(String line : lines) {
        if(line.indexOf(filter) != -1) {
            return n;
        }
        n++;
    }
    return -1;
}