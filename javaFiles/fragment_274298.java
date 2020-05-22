BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./path"));
int n = readInt(bis);
int t = readInt(bis);
int array[] = new int[n];
for (int i = 0; i < n; i++) {
    array[i] = readInt(bis);
}

private static int readInt(InputStream in) throws IOException {
    int ret = 0;
    boolean dig = false;

    for (int c = 0; (c = in.read()) != -1; ) {
        if (c >= '0' && c <= '9') {
            dig = true;
            ret = ret * 10 + c - '0';
        } else if (dig) break;
    }

    return ret;
}