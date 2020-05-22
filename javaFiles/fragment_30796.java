LineNumberReadr lr = new LineNumberread(br);
while ((line = lr.readLine()) != null) {
  if (line.contains("| ERROR |")) {
    jLogEntries.put("line " + lr.getLineNumber(), line);
    for (int i = 0; i < 5; i++) {
      if ((line = lr.readLine()) != null) {
        jLogEntries.put("line " + lr.getLineNumber(), line);
      }
  }
}