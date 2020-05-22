double variance=0;
for(String token : tokens) {
  double value = Double.parseDouble(token);
  variance += Math.pow(value-average,2);
}
variance = variance/tokens.length;