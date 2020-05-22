public String myMethod(String... args) {
  String[] concatenatedArray = new String[args.length + 1];
  concatenatedArray[0] = "other string";
  for (int i = 0; i < args.length; i++) { // or System.arraycopy...
    concatenatedArray[i + 1] = args[i];
  }
  return myOtherMethod(concatenatedArray);
}