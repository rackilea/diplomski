public class MonSOAPBindingCodec extends MonMimeCodec implements com.sun.xml.ws.api.pipe.SOAPBindingCodec {
...
    public MonSOAPBindingCodec(WSFeatureList features, StreamSOAPCodec xmlSoapCodec) {
        super(getSoapVersion(features), features);

        this.xmlSoapCodec = xmlSoapCodec;
        xmlMimeType = xmlSoapCodec.getMimeType();

        String clientAcceptedContentTypes = xmlSoapCodec.getMimeType() + ", */*";

        WebServiceFeature fi = features.get(FastInfosetFeature.class);
...