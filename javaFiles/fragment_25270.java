for (int i = 0; i < s.length() - 1; i += 1) {
    char c = s.charAt(i);
    char current = s.charAt(i + 1);
    if (c == current) {
        count += 1;
    }
    else {
        if (count > max) {
            max = count; // #1
        }
        count = 1; // #2
    }
}
if(count > max) // #3
    max = count;

return max;