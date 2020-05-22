class wiki
{
    public void parseWiki(){
        // initialize Semaphore object
        Semaphore semaphore = new Semaphore(1); 
        //pass it to callback handler so it can release semaphore latter
        PageCallbackHandler handler = new WikiPageCallbackHandler(semaphore);
        //This is the async operation, right?
        WikiXMLSAXParser.parseWikipediaDump(filepath, handler );
        //wait until a permit is available (when semaphore.release() is called)
        semaphore.acquire(); //this throw InterruptedException, please handle it else where
    }
}

class WikiPageCallbackHandler implements PageCallbackHandler 
{
    private Semaphore semaphore;
    public WikiPageCallbackHandler(Semaphore semaphore){
        this.semaphore = semaphore;
    }
    //Override
    //This is the callback
    void process(WikiPage page)
    {
        try{
            String Text = page.GetText();
            //Write this text into a file
            .....
        }finally{
            semaphore.release();
        }
    }
}