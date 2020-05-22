File file = new File(filename);
long destSize = 1000000;
long orgSize = file.length();
if (destiSize > orgSize) {
    long diff = destSize - orgSize;
    try (FileOutputStream fos = new FileOutputStream(file, true)) {
        byte[] buf = new byte[4096];
        while (diff > 0) {
            int len = (int) Math.min(buf.length, diff);
            fos.write(buf, 0, len);
            diff -= len;
        }
    }
}