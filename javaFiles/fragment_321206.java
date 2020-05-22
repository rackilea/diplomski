StringBuilder sb = new StringBuilder(
        "Hello, how are you?\nFine thanks!\nOk, Perfect...\n\n");
if (sb.length() > 0) {
    int last, prev = sb.length() - 1;
    while ((last = sb.lastIndexOf("\n", prev)) == prev) { prev = last - 1; }
    if (last >= 0) { sb.delete(last, sb.length()); }
}