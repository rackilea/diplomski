public static char[] cookie = "HEADER_COOKIE".toCharArray();
byte[] cookieInBytes = new byte[COOKIE_SIZE];
for(int i=0;i<cookie.length;i++)
        {
            if(i < cookie.length)
                cookieInBytes[i] = (byte)cookie[i];

        }
String headerStr = new String(cookieInBytes,StandardCharsets.UTF_8);