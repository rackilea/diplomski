public static long Decode(String UserId)
    {
        int FILL_CHAR_EQUAL = 1;
        int type = 0;
        if (UserId == null)
        {
            throw new ArgumentException("UserId can't be null");
        }

        if (UserId.EndsWith("="))
        {
            // new encoding
            type = 1;
        }
        else
        {
            // old encoding
            type = 2;
        }

        bool useStandardEnding = (type == FILL_CHAR_EQUAL);
        byte[] bytes = Convert.FromBase64String(UserId);
        if (bytes.Length < 40)
        {
            throw new ArgumentException(
                "Base64 decoded length of UserId should be 40 (Actual="
                    + bytes.Length + ";UserId=" + UserId + ")");
        }

        // exclusive or
        byte[] xor = new byte[] { (byte)0xa0, (byte)0xb2, (byte)0x91, (byte)0x20 };
        int cnt = 0;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                bytes[cnt] = (byte)(bytes[cnt] ^ xor[j]);
                cnt++;
            }
            xor[3] += 4;
        }
        // rotate right 2 entities
        byte[] buffer = new byte[8];
        Array.Copy(bytes, 32, buffer, 0, 8);
        Array.Copy(bytes, 0, bytes, 8, 32);
        Array.Copy(buffer, 0, bytes, 0, 8);
        // remove leading '=' and convert to int
        String str = Encoding.Default.GetString(bytes);
        int pos = str.LastIndexOf('=');
        str = str.Substring(pos + 1);
        // Added to remove the extra spaces in the userid-ebay-PayPal
        // Integration.
        str = (str == null) ? null : str.Trim();
        return long.Parse(str);
    }