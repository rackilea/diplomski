for (int i = 0; i< inputArr.length; i++) {
    String current = inputArr[i];
    String suffix = "ABC";
    String replacement = current == null ? suffix : current + suffix;
    inputArr[i] = replacement;
}