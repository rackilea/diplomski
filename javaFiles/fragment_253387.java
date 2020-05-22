public static void main(String[] args) 
{
    try
    {           
        Processor proc = new Processor(false);
        DocumentBuilder builder = proc.newDocumentBuilder();
        XPathCompiler xpc = proc.newXPathCompiler();

        XPathSelector selector = xpc.compile("//book/title").load();
        selector.setContextItem(builder.build(new File("books.xml")));
        for (XdmItem item: selector) 
        {
            System.out.println(item.getStringValue());
        }
    }   

    catch(Exception e)
    {
        e.printStackTrace();
    }
}