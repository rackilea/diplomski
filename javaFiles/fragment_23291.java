public static String getHref(String str)
    {
        int startIndex = str.indexOf("href=");
        if (startIndex < 0)
            return "";
        return str.substring(startIndex + 6, str.indexOf("\"", startIndex + 6));
    }