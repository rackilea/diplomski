public myClass(String htmlInput)
{
    openedTags = new Stack<String>();
    this.htmlInput = htmlInput;
}
public boolean validate()
{
    return validate(this.htmlInput);
}
private boolean validate(String html)
{
    boolean result = true;
    String curTag;
    while(htmlLeft)        //worker loop
    {

        if(isOneOffTag(curTag))                 //matches <tags />
            continue;
        else if(isOpenTag(curTag))              //matches <tags>
        {
            openedTags.push(curTag);
            if(!validate(innerHtml))
                return false;
        }
        else if(isCloseTag(curTag))             //matches </tags>
        {
            String lastTag = (String)openedTags.peek();
            if(!tagIsSimiliar(curTag, lastTag))
                return false;
            openedTags.pop();
        }
    }


    return result;
}
private String nextTag(){return null;}
private boolean isOpenTag(String tag){ return true;}
private boolean isCloseTag(String tag){ return true;}
private boolean isOneOffTag(String tag){ return true;}
private boolean tagIsSimiliar(String curTag, String lastTag){return true;}