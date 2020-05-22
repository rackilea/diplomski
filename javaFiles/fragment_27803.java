@WebMethod(operationName = "removeorder2")
public String removeorder2(@WebParam(name = "cliente") String id) {
    boolean check = false;
    URL u = this.getClass().getResource("orders.xml");
    Document doc = XMLJDomFunctions.lerDocumentoXML(u.getFile());
    Element encomendas = doc.getRootElement();
    for (int i = 0; i < encomendas.getChildren().size(); i++) {
        Element filho = encomendas.getChildren().get(i);
        if (filho.getAttribute("cliente").getValue().equals(id)) {
            encomendas.getChildren().remove(i);
            XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, u.getFile());
            check = true;
        }

    }
    if (check) return "order removed";
    return "order doesnt exist";
}