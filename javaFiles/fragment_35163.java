// if you're dead set on having at least 16 chars, put this before the return statement
int padding = 16 - binaryVers.length();
while (padding > 0) {
    binaryVers = "0" + binaryVers;
    padding--;
}