private void getParsedXML(String s) throws Exception{
    if(this.levelData == null){
        /* Get a SAXParser from the SAXPArserFactory. */
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLHandlerLevel myExampleHandler = new XMLHandlerLevel();
        XMLReader xr = sp.getXMLReader();
        /* Begin parsing */
        InputSource is = new InputSource(new StringReader(string));
        xr.parse(is);

        this.levelData = myExampleHandler.getLevelData();
        Log.e("jason",(levelData!=null)?levelData.toString():null);
        in.close();
    }
}