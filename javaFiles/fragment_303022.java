// Search starts at pos+1, so we set pos to -1 to start search at zero
int pos = -1;
// We'll break out of the loop when there are no further matches
while (true) {
    // Look for the desired character starting one character past the pos
    pos = s.indexOf(input, pos+1);
    // If the character is not found, end the loop
    if (pos < 0) break;
    // Otherwise, replace the character
    s.setCharAt(pos, ch);
}