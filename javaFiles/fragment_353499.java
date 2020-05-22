byte[] array = new byte[4096];
for (byte b : array) {
    if (b != 0) {
        return false;
    }
}