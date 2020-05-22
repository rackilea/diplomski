int start = 0;
int end = bookshelf.size();
while (start < end) {
    if (bookshelf.get(start) instanceof Dictionary) {
        bookshelf.moveToEnd(start);
        end--;
    } else {
        start++;
    }
}