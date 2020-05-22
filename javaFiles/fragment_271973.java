// introduce a local variable, you don't want to perform charAt twice
char c = plainText.charAt(i);
int charPosition = ALPHABET.indexOf(c);
// if charPositions is -1 then it is not found 
if (charPosition == -1) { // or define a constant NOT_FOUND = -1
    cipherText += c;
    // continue with the for loop
    continue;
}