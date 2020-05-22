public String getUnicodeEscapes(String aString)
{
    if (aString != null && aString.length() > 0)
    {
        int length = aString.length();
        StringBuilder buffer = new StringBuilder(length);
        for (int ctr = 0; ctr < length; ctr++)
        {
            char codeUnit = aString.charAt(ctr);
            String hexString = Integer.toHexString(codeUnit);
            String padAmount = "0000".substring(hexString.length());
            buffer.append("\\u");
            buffer.append(padAmount);
            buffer.append(hexString);
        }
        return buffer.toString();
    }
    else
    {
        return null;
    }
}