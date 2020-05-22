private static void splitFormula(String formula){
    partialFormula.clear();

    StringBuilder newStr = new StringBuilder();

    for (int index = 0; index < formula.length(); index++) {
        char c = formula.charAt(index);
        if (c == '-' || c == '+' || c == '*' || c == '/') {
            partialFormula.add(newStr.toString());
            newStr.setLength(0);
        } else {
            newStr.append(c);
        }
    }
    partialFormula.add(newStr.toString());
}