public String getUnicodeCodepoints(String aString)
{
    if (aString != null && aString.length() > 0)
    {
        int length = aString.length();
        StringBuilder buffer = new StringBuilder(length);
        for (int ctr = 0; ctr < length; ctr++)
        {
            char ch = aString.charAt(ctr);
            if (Character.isLowSurrogate(ch))
            {
                continue;
            }
            else
            {
                int codePoint = aString.codePointAt(ctr);
                String hexString = Integer.toHexString(codePoint);
                String zeroPad = Character.isHighSurrogate(ch) ? "00000" : "0000";
                String padAmount = zeroPad.substring(hexString.length());
                buffer.append(" U+");
                buffer.append(padAmount);
                buffer.append(hexString);
            }
        }
        return buffer.toString();
    }
    else
    {
        return null;
    }
}