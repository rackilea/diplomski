unit u = new unit();
for(int i=0;i<;header1.lenght;i++) {
  String h = header1[i];
  String v = value11[i];
  Field f = u.getClass().getDeclaredField(h);
  f.set(u, v);
}