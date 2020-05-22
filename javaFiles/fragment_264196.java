char[] data = new char[len / 2];
for (int i = 0; i < len; i += 2) {
    data[i / 2] = (char) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
}

return new String(data);