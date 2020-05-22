double dd;
try {
    dd = Double.parseDouble(string);
}
catch (NumberFormatException e) {
    System.out.println("couldnt not parse the string!");
}