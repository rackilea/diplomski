byte[] bytes = new byte[(int)file.length()];

FileInputStream in = new FileInputStream(file);
in.read(bytes);
in.close();

char[] text = new char[bytes.length];
for (int i = 0; i < bytes.length; i++) {
    text[i] = (char)(bytes[i] & 0xFF);
}

for (String line : new String(text).split("\n")) {
    //
}