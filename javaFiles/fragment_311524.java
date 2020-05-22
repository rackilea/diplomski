if (line == null)
  return content;
do {
  content = Integer.parseInt(line);
  line = br.readLine();
} while (line != null);