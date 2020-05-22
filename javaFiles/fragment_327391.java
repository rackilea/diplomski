public void setMaximum(String maximum) {
   Strin[] array = splitByDelimiter(maximum, ":");
   int i = 0;
   mMaxValues = new int[array.length];
   for (String value : array) {
       mMaxValues[i] = Integer.parseInt(value);
       i++;
   }
}