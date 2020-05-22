public final class SampleParser{


    final static String ROOT_NODE = "maths";
    final static String ELEMENT_MATHAMETICIAN = "mathametician";
    final static String ELEMENT_ID = "id";
    final static String ELEMENT_NAME = "name";
    final static String ELEMENT_AGE = "age";

    private static final String TAG="SampleParser";

    /**
     * Intentionally commented
     */
    private SampleParser() {}

    /**
     * @param response The XML string which represents the complete news data
     * @return news The complete data
     */
    public static Maths parse(String response) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp;
        try {
            sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            SampleDataHandler dataHandler = new SampleDataHandler();
            xr.setContentHandler(dataHandler);
            InputSource source = new InputSource(new StringReader(response)); 
            xr.parse(source);
            Maths result = dataHandler.getData();
            return result;
        } catch (ParserConfigurationException e) {
            Log.e(TAG, "parse", e);
        } catch (SAXException e) {
            Log.e(TAG, "parse", e);
        } catch (IOException e) {
            Log.e(TAG, "parse", e);
        } 
        return null;
    }

    static class SampleDataHandler extends DefaultHandler {
        /**
         * 
         */
        private static final String TAG="NewsDataHandler";
        /**
         * 
         */
        private Maths data;
        /**
         * 
         */
        private Mathematician tempElement;
        /**
         * 
         */
        private boolean readingAge;
        /**
         * 
         */
        private boolean readingName;
        /**
         * 
         */
        private boolean readingID;
        /**
         * 
         */
        public Maths getData(){
            return data;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.xml.sax.helpers.DefaultHandler#endDocument()
         */
        @Override
        public void endDocument() throws SAXException {
            Log.d(TAG, "endDocument Finished parsing response");
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
         * java.lang.String, java.lang.String)
         */
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if(qName.equalsIgnoreCase(ELEMENT_MATHAMETICIAN)){
                data.addMathematician(tempElement);
            }else if(qName.equalsIgnoreCase(ELEMENT_ID)){
                readingID = false;
            }else if(qName.equalsIgnoreCase(ELEMENT_NAME)){
                readingName = false;
            }else if(qName.equalsIgnoreCase(ELEMENT_AGE)){
                readingAge = false;
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.xml.sax.helpers.DefaultHandler#startDocument()
         */
        @Override
        public void startDocument() throws SAXException {
            data = new Maths();
            Log.d(TAG, "startDocument Started parsing response");
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
         * java.lang.String, java.lang.String, org.xml.sax.Attributes)
         */
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            if(qName.equalsIgnoreCase(ROOT_NODE)){
                //data.setData(new ArrayList<NewsElement>());
            }else if(qName.equalsIgnoreCase(ELEMENT_AGE)){
                readingAge=true;                
            }else if(qName.equalsIgnoreCase(ELEMENT_MATHAMETICIAN)){
                tempElement = new Mathematician();
            }else if(qName.equalsIgnoreCase(ELEMENT_ID)){
                readingID=true;
            }else if(qName.equalsIgnoreCase(ELEMENT_NAME)){
                readingName=true;
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
         */
        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            String chars = new String(ch, start, length);    
            chars = chars.trim(); 
            if(readingID){
                try{
                    tempElement.setId(Integer.parseInt(chars));
                }catch(Exception e){
                    Log.e(TAG, "characters[Parsing ID]", e);
                    tempElement.setId(-1);
                }
            }
            else if(readingAge){
                try{
                    tempElement.setAge(Integer.parseInt(chars));
                }catch(Exception e){
                    Log.e(TAG, "characters[Parsing Age]", e);
                    tempElement.setAge(-1);
                }
            }else if(readingName){
                tempElement.setName(chars);
            }
        }
    }
}