public class OtherProductConverter implements Converter {
    private ProductUnmarshaller productUnmarshaller = new ProductUnmarshaller();

    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
        return clazz.equals(OtherProduct.class);
    }

    @Override
    public void marshal(Object object, HierarchicalStreamWriter hsw, MarshallingContext mc) {
        OtherProduct otherProduct = (OtherProduct) object;
        hsw.startNode("Id");
        hsw.setValue(Integer.toString(otherProduct.getId()));
        hsw.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hsr, UnmarshallingContext uc) {
        return productUnmarshaller.unmarshal(hsr, uc);
    }


}