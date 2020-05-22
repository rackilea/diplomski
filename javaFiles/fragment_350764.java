public class YourFilenameFilter extends java.io.FilenameFilter
{
    public boolean accept(java.io.File file, String name)
    {
        boolean shouldAccept = false;
        if(name!=null)
        {
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("[A-Z][A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9].FILE");
            java.util.regex.Matcher m = p.matcher(name);
            if(m.matches()) {
                shouldAccept = true;
            }
        }
        return shouldAccept;
    }
}