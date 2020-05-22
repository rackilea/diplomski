double parseTerm() {
    double x = parseFactor();
    while(true) {
        if (shift('*')) {
            x *= parseFactor(); // multiply
        } else if (shift('/')) {
            x /= parseFactor(); // divide
        } else if (shift('(')) { // brackets
            x *= parseExpression();
            shift(')');
        } else {
            return x;
        }
    }
}