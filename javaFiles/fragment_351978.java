String src = "=D0=93=D0=B0=D0=B7=D0=B5=D1=82=D0=B0";

assert src.length() % 3 == 0;
byte[] bytes = new byte[src.length() / 3];
for (int i = 0, j = 0; i < bytes.length; i++, j+=3) {
    assert src.charAt(j) == '=';
    bytes[i] = (byte)(Character.digit(src.charAt(j + 1), 16) << 4 |
                      Character.digit(src.charAt(j + 2), 16));
}
String str = new String(bytes, StandardCharsets.UTF_8);

System.out.println(str);