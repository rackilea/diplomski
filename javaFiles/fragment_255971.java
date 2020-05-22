String[] numberParts = input.split("[\\s,]+");
double[] doubles = new double[numberParts.length];
int i=0;
for (String part : numberParts) {
   double value = Double.parseDouble(part);
   doubles[i++] = value;
}