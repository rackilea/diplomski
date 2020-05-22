/**
 * Method to extract the first number from a String
 * Will return either a double or long depending on whether the number contains decimal digits
 */
public Number extractNumber(String str) throws java.text.ParseException{
  // Check if the input-String contains any digit:
  if(!str.matches(".*\\d.*"))
    // If not, return 0
    return 0;

  // Extract the first number:
  String extractedNr = str.replaceAll(".*?([-+]*\\d+(\\.\\d*)?).*", "$1");
  // Replace any "-+" or "+-" with just "-",
  extractedNr = extractedNr.replace("-+", "-").replace("+-", "-")
  // And remove any "--" since they neutralize each other
                           .replace("--", "");

  // Convert the extracted number to a Double
  // TODO: Try-catch the ParseException
  double decResult = Double.parseDouble(extractedNr);
  // If the extracted number does NOT contain decimal digits:
  if(decResult % 1 == 0){
    // Return the result as long
    return (long)decResult;
  } else{
    // If it does contain decimal digits, just return it as double instead
    return decResult;
  }
}