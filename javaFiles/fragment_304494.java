public class MyJavaScriptInterface
{
    private String strval;

    public MyJavaScriptInterface()
    {
        strval = null;
    }

    @SuppressWarnings("unused")

    @JavascriptInterface

    public void getHighlightedText(String hword)
    {
        if(!hword.isEmpty())
        {
            strval = hword;
            new getWordDefinition().execute("http://api.wordnik.com/v4/word.json/"+hword+"/definitions?limit=1&includeRelated=false&useCanonical=false&includeTags=false&api_key=a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5");
        }
        else
            strval="";
    }

    public String returnHtml()
    {
        return strval;
    }
}