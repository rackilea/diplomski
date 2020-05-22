PrintWriter w = new PrintWriter(System.out);
for (int i = 0; i < message.length(); i += 10) {
  w.write(message, i, Math.min(i + 10, message.length());
  w.write(System.lineSeparator());
}   
w.flush();