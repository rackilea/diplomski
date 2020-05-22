for (;;) {
  int charsRead = reader.read(buf);
  if (charsRead < 0) {
    break;
  }

  writer.write(buff, 0, charsRead);
}