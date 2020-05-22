while (count < start) {
    updated += getChar(word, count);
    count++;

}

while (end + 1 < length(word)) {
    updated += getChar(word, end + 1);
    end++;

}