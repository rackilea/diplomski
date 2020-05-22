String formula = "C3H20IO";

//insert "1" in atom-atom boundry 
formula = formula.replaceAll("(?<=[A-Z])(?=[A-Z])|(?<=[a-z])(?=[A-Z])|(?<=\\D)$", "1");

//split at letter-digit or digit-letter boundry
String regex = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
String[] atoms = formula.split(regex);