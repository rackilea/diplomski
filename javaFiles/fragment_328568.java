Pattern p = Pattern.compile("\\W");

boolean containsSpecialChars(String string)
{
    Matcher m = p.matcher(string);
    return m.find();
}