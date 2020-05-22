int[] utf8Array = {72, 195, 164, 108, 108, 111};
byte[] bytes = new byte[utf8Array.length];
for (int i = 0; i < utf8Array.length; ++i) {
    bytes[i] = (byte) utf8Array[i];
}
String theString = new String(bytes, Charset.forName("UTF-8"));