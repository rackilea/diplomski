/*
@invariant The "Word" fields cannot have commas in thier values or the conversion
to a list will cause bad field breaks. CSV data sucks...
*/
public List<String> stringFormatedToStringList(String s) {
  // oneliner for the win:
  return Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"","").split(","));
  // .substring  removes the first an last characters from the string ('[' & ']')
  // .replaceAll removes all quotation marks from the string (replaces with empty string)
  // .split brakes the string into a string array on commas (omitting the commas)
  // Arrays.asList converts the array to a List
}