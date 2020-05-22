if (codec != null) {
  in = new LineReader(codec.createInputStream(fileIn), job);
  end = Long.MAX_VALUE;
} else {
  if (start != 0) {
    skipFirstLine = true;
    --start;
    fileIn.seek(start);
  }
  in = new LineReader(fileIn, job);
}
if (skipFirstLine) {  // skip first line and re-establish "start".
  start += in.readLine(new Text(), 0,
                       (int)Math.min((long)Integer.MAX_VALUE, end - start));
}