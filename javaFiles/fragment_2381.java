public static String trim (String str, String prefix, String suffix)
{
    int indexOfLast = str.lastIndexOf(suffix);

    // Note: you will want to do some error checking here 
    // in case the suffix does not occur in the passed in String

    str = str.substring(0, indexOfLast);

    return str.replaceFirst(prefix, "");
}