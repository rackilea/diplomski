String line = readLineFromSubProcess();
String[] parts = line.split(":");

if (parts[0].equals("double")) {
  return Double.parseDouble(parts[1]);
} else if (parts[0].equals("double_as_int64") {
  return Double.longBitsToDouble(Long.parseLong(parts[1]));
} else if (parts[0].equals("float_as_int32") {
  return Float.intBitsToFloat(Integer.parseInt(parts[1]));
}