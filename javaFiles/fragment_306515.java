@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})

public class CardSaleRequestEnvelope {

    @Element(name = "soap12:Header", required = true)
    private CardSaleRequestHeader header;

    @Element(name = "soap12:Body", required = true)
    private ZCardSaleRequestBody zbody;

    public CardSaleRequestEnvelope() {
    }


    public CardSaleRequestHeader getHeader() {
        return header;
    }

    public void setHeader(CardSaleRequestHeader header) {
        this.header = header;
    }

    public ZCardSaleRequestBody getBody() {
        return zbody;
    }

    public void setBody(ZCardSaleRequestBody zbody) {
        this.zbody = zbody;
    }
}