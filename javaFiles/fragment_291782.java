SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
saxParser.parse("input.xml", new DefaultHandler()
{
    @Override
    public void processingInstruction(String target, String data)
        throws SAXException
    {
        if (target.equals("xml-stylesheet"))
        {
            Pattern pattern = Pattern.compile("href=\"(.+)\"");
            Matcher matcher = pattern.matcher(data);
            if (matcher.find())
                System.out.println(matcher.group(1));
        }
    }
});