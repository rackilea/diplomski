try {
    Double d = Double.parseDouble(doubleToParse);
    array.add(d);
} catch (NumberFormatException ex) {
    System.out.println(ex.getMessage());
}