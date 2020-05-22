int dst = 0;
for (int src = 0; src < logData1.size(); ++src) {
  if (!bits.get(src)) {
    logData1.set(dst++, logData1.get(src));
  }
}