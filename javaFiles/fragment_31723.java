char[] buffer = new char[1024];
int read = 0;
StringBuilder sb = new StringBuilder();

while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
    sb.append(buffer, 0, read);
    // conduct some test that when passes marks the end of message, then break;
}
reader.close();

String str = sb.toString().trim();