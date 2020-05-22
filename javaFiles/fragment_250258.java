@Component
public class PCPrecoClient {

    private final Logger log = LoggerFactory.getLogger(PCPrecoClient.class);
    private final HttpHeaders defaultHeaders = new HttpHeaders();
    private final RestTemplate restTemplate = new RestTemplate();

    public PCPrecoClient() {
        defaultHeaders.setContentType(MediaType.TEXT_XML);
        defaultHeaders.set("SOAPAction","urn:uPCPrecoIntf-PC_Preco#Pesquisar");
        defaultHeaders.setAcceptCharset(Collections.singletonList(Charset.forName("UTF-8")));
    }

    public BigDecimal pesquisar(int codigoProduto){
        String requestBody="<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:uPCPrecoIntf-PC_Preco\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <urn:Pesquisar soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "         <Codigo_Produto xsi:type=\"xsd:int\">"+codigoProduto+"</Codigo_Produto>\n" +
            "      </urn:Pesquisar>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, defaultHeaders);
        String finalUrl = "http://192.168.1.13/PCSIS2699.EXE/soap/PC_Preco";
        try {
            ResponseEntity<String> response = restTemplate.exchange(finalUrl, HttpMethod.POST, httpEntity, String.class);
            return extrairPreco(response.getBody());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

    private BigDecimal extrairPreco(String responseBody) {
        String tagAbertura="<preco_venda>";
        int startIndex=responseBody.indexOf(tagAbertura)+tagAbertura.length();
        int endIndex=responseBody.indexOf("</preco_venda>");
        if(startIndex==-1 || endIndex==-1)
            return null;
        return new BigDecimal(responseBody.substring(startIndex,endIndex));

    }
}