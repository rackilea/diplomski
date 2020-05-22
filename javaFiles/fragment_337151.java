public class ProductConverter implements Converter {
    private ProductUnmarshaller productUnmarshaller = new ProductUnmarshaller();

    @Override
    public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
        return clazz.equals(Product.class);
    }

    @Override
    public void marshal(Object object, HierarchicalStreamWriter hsw, MarshallingContext mc) {
        Product product = (Product) object;
        hsw.startNode("Name");
        hsw.setValue(product.getName());
        hsw.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hsr, UnmarshallingContext uc) {
        return productUnmarshaller.unmarshal(hsr, uc);
    }

}