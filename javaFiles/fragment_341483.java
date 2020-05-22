int generateHashCode(int a,int b) {
    // Start with a non-zero constant. Prime is preferred
    int result = 17;
    // For each field multiply the previous result by a prime and add
    result = 31 * result + a;         
    result = 31 * result + b;         
    return result;
}