try {
  Integer.parseInt(s);
  data_int.add(Integer.parseInt(s));
} catch(NumberFormatException e) {
  try {
    Double.parseDouble(s);
    data_double.add(Double.parseDouble(s));
  } catch(NumberFormatException e) {
    data_String.add(s);
  }
}