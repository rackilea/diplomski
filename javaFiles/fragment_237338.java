string.split("\|"); // won't work because \| is not a valid escape sequence
string.split("/|"); // will compile, but split on / and empty space, so between each character
string.split("|");  // will compile, but split on empty space, so between each character

// true alternative to quoted solution above
 string.split("\\|") // escape the second \ which will resolve as an escaped | in the regex pattern