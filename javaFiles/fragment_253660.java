Process proc = null;
try {
  proc = Runtime.getRuntime().exec(new String[] { "logcat", <!parametes_here!> });
  mReader = new BufferedReader(new InputStreamReader(proc.getInputStream()), 1024);
  String line;
  while ((line = mReader.readLine()) != null) {
   if (line.length() == 0) {
    continue;
   }
  mHandler.sendMessage(mHandler.obtainMessage(Logcat.MSG_READ_LINE, line));
 }
} catch (IOException e) {
 Log.e(TAG, "Cannot start process", e);
} finally {
  if (mReader != null)
  try {
    mReader.close();
  } catch (IOException e) {
    Log.e(TAG, "Cannot close stream", e);
 }
}