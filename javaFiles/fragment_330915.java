Reader reader = new BufferedReader(new FileReader(file));
StringBuilder builder = new StringBuilder();

int c;
while ((c = reader.read()) != -1) {
    builder.append((char) c);
}

String string = builder.toString();