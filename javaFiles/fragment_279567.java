InputStream inputStream = System.in;
InflaterInputStream inflaterInputStream =  new InflaterInputStream(inputStream);

StringBuilder toReturn = new StringBuilder();
int c;
while ((c = inflaterInputStream.read()) != -1) {
    toReturn.append((char) c);
    if ((char) c == '\n') {
        System.out.println(toReturn.toString());
        toReturn.setLength(0);
    }
}