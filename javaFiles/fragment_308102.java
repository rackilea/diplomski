outputString = new StringBuilder(str).reverse().toString();
// outputString is now hiah
outputString = outputString.replaceAll("(.)(?=.*\\1)", "");
// outputString is now iah
outputString = new StringBuilder(outputString).reverse().toString();
// outputString is now hai