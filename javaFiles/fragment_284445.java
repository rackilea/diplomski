String       s = "10.1.1.99";
Inet4Address a = (Inet4Address) InetAddress.getByName(s);
byte[]       b = a.getAddress();
int          i = ((b[0] & 0xFF) << 24) |
                 ((b[1] & 0xFF) << 16) |
                 ((b[2] & 0xFF) << 8)  |
                 ((b[3] & 0xFF) << 0);