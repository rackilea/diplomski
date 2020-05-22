public class MapMaker {

    private final static String MAP_FLAT = "BlankMap-World6-Equirectangular.svg";
    private final static String MAP_ROUND = "WorldMap.svg";

    public static void main(String... args) {

        try {
            // make a Document with the base map 
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            Document doc = f.createDocument("http://example.com/stuff",
                    MapMaker.class.getClassLoader().getResourceAsStream(MAP_ROUND));

            // prepare to modify and transcode the document
            SVGDocument sdoc = (SVGDocument) doc;
            Element svgRoot = sdoc.getDocumentElement();
            PNGTranscoder t = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(doc);

            // find the existing stylesheet in the document
            NodeList stylesList = doc.getElementsByTagName("style");
            Node styleNode = stylesList.item(0);

            // append another stylesheet after the existing one
            SVGStyleElement style = (SVGStyleElement) doc.createElementNS(SVG_NAMESPACE_URI, "style");
            style.setAttributeNS(null, "type", "text/css");
            style.appendChild(doc.createCDATASection(".us {fill: blue;}"));
            styleNode.getParentNode().appendChild(style);

            // transcode the map
            OutputStream ostream = new FileOutputStream("outblue.jpg");
            TranscoderOutput output = new TranscoderOutput(ostream);
            t.transcode(input, output);
            ostream.close();

            // replace the appended stylesheet with another
            SVGStyleElement oldStyle = style;
            style = (SVGStyleElement) doc.createElementNS(SVG_NAMESPACE_URI, "style");
            style.setAttributeNS(null, "type", "text/css");
            style.appendChild(doc.createCDATASection(".us {fill: green;}"));
            styleNode.getParentNode().replaceChild(style, oldStyle);

            // transcode the revised map
            File outFile = new File(System.getProperty("java.io.tmpdir"), "outgreen.png");
            ostream = new FileOutputStream(outFile);
            output = new TranscoderOutput(ostream);
            t.transcode(input, output);
            ostream.close();
            System.out.println("Out File: " + outFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}