private static void splitFormula(String formula){
    partialFormula.clear(); // since there is a method for this, why not use it?

    int lastIndex = 0;
    for (int index = 0; index < formula.length(); index++) {
        char c = formula.charAt(index);
        if (c == '-' || c == '+' || c == '*' || c == '/') {
            partialFormula.add(formula.substring(lastIndex, index));
            lastIndex = index + 1; //because if it were index, it would include the operator
        }
    }
    partialFormula.add(formula.substring(lastIndex));
}