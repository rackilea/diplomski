byte[] a = { 0x3F, 0x2C, 0x6A };
String[] s = new String[a.length];
for (int i=0; i<a.length; i++) {
  s[i] = String.format("%02X", a[i]);
}
// s => ["3F", "2C", "6A"]