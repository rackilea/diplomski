public class ProductUnmarshaller {

    public Object unmarshal(HierarchicalStreamReader hsr, UnmarshallingContext uc) {
        hsr.moveDown();

        String nodeName = hsr.getNodeName();
        String nodeValue = hsr.getValue();

        hsr.moveUp();

        if ("Name".equals(nodeName)) {
            return new Product(nodeValue);
        } else if ("Id".equals(nodeName)) {
            return new OtherProduct(Integer.parseInt(nodeValue));
        } else {
            return null;
        }



    }

}