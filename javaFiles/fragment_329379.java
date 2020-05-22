public static String strip(String message) // lowercase strip due to Java naming conventions
{
    Matcher matcher = CODE_ANY.matcher(message);
    if (matcher.find())
        message = matcher.replaceAll("");
    return message;
}