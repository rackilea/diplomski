InputStream is = s.getInputStream();
int val = 0;
for(int i = 0; i<4; i++) {
    val <<= 8; // does nothing first time
    val |= is.read();
}
System.out.println(val);