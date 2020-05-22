Pattern pattern = Pattern.compile(".* (Ka).*");
Matcher matcher = pattern.matcher("Manoj Kumar Kashyap");
if(matcher.matches())
{
    int idx = matcher.start(1);
}