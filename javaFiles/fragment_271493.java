StringBuilder sb = new StringBuilder(65536); // Consider a large initial size
String line
while ((line=bf.readLine())!=null) {
     sb.append(line);
}

// OutString is in the sb StringBuilder
String outStr = sb.toString();