//In constructor, or as a static variable.
//This regex is a better form of yours.
Pattern operatorPattern = Pattern.compile("[-*+/]");
...
private static void splitFormula(String formula){
    partialFormula.clear();

    for(String temp: operatorPattern.split(formula)) {
        partialFormula.add(temp);
    }
}