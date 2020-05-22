public class XMLFileParser {

    private static final Logger log = Logger.getLogger(XMLFileParser.class.getName());

    private Document document;

    /**
     * Method will construct a Document Object from the given InputStream
     * @param readIn The input stream to read the document.
     */
    public XMLFileParser(InputStream readIn) {
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(readIn);
        }catch (DocumentException ex) {
            log.error("Error when attempting to parse input data file", ex);
        }
    }

    /**
     * Write a method to iterate over the nodes to actually parse the xml file. 
     */
    public HashMap<String, Object> parseInput(HashMap<String, Object> params) { 
        Element rootElement = document.getRootElement();
        for(Iterator iter = rootElement.elementIterator("Parameter"); iter.hasNext();) {
                // This where you should write your parse logic,  
             }

        return params;
    }