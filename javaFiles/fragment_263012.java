int score = 0;
try {
    score = Integer.parseInt(strScore);
} catch (NumberFormatException nfe) {
    // This means NFE was thrown, so the field text cannot be parsed
    // to a numerical value. Just leave score = 0 as it was initialized
}