File file = new File("/Users/Desktop/shakes.txt");
FileReader reader = new FileReader(file);

int ch;
StringBuilder sb = new StringBuilder();
long start = System.currentTimeMillis();
while ((ch = reader.read()) != -1) {
    //System.out.print((char) ch);
    sb.append((char) ch);
}
long end = System.currentTimeMillis();

System.out.println(sb);