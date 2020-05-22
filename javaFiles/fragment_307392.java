String [] a = getA();
String [] b = getB();
Map<String, String> mapNumeric = new HashMap<>();
for (int i=0; i < Math.min(a.length, b.length); i++) {
   mapNumeric.put(a[i], b[i]);
}