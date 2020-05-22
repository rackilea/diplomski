public Triangle_getvalues(int a, int b, int c) throws InvalidValueException {
    validateTriangle(a, b, c);
    setSide1(a);
    setSide2(b);
    setSide3(c);
}