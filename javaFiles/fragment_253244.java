Charset ascii = Charset.forName("US-ASCII");
System.out.println(ascii.aliases());
// [ANSI_X3.4-1968, cp367, csASCII, iso-ir-6, ASCII, iso_646.irv:1983, ANSI_X3.4-1986, ascii7, default, ISO_646.irv:1991, ISO646-US, IBM367, 646, us]

System.out.println(ascii.newEncoder().maxBytesPerChar());
// 1.0

Charset utf8 = Charset.forName("UTF-8");
System.out.println(utf8.newEncoder().maxBytesPerChar());
// 3.0