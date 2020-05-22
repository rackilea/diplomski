String minkey = null;
String maxkey = null;
for(String keyset: maxMin.keySet()){
  double values = maxMin.get(keyset);
  if (values < min) {
     min = values;
     minkey = keyset;
  }
  if (values > max) {
     max = values;
     maxkey = keyset;
  }
}