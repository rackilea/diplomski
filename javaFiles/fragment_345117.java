public class ConsStatServ {
    .
    .
    .
    @XmlAttribute(name = "xmlns", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xmlns = "http://www.portalfiscal.inf.br/nfe";
    public String getXmlns() {
        return xmlns;
    }
}