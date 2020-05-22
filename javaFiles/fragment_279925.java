Double temp = entries.get(getString);
if (temp != null) {
  if (temp.doubleValue() == 0) {
    temp = 0.00000001;
  }
  tempVal.put(getString, Math.abs(Math.log10(temp));
}