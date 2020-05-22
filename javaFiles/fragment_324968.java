StringBuilder builder = new StringBuilder();
char[] buffer = new char[4096];
InputStreamReader reader = new InputStreamReader(in, "UTF-8");
int charsRead;
while ((charsRead = reader.read(buffer)) != -1) {
    builder.append(buffer, 0, charsRead);
}