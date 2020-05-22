public class ProductTest {
    @Test
    public void test() {
        Product productOne = new Product("One");
        Product productTwo = new Product("Two");

        OtherProduct otherProduct1 = new OtherProduct(1);
        OtherProduct otherProduct2 = new OtherProduct(2);

        GroupData group = new GroupData();
        group.add(productOne);
        group.add(productTwo);
        group.add(otherProduct1);
        group.add(otherProduct2);

        XStream xs = new XStream();
        xs.processAnnotations(GroupData.class);
        xs.processAnnotations(OtherProduct.class);
        xs.processAnnotations(Product.class);
        xs.registerConverter(new ProductConverter());
        xs.registerConverter(new OtherProductConverter());
        String xml = xs.toXML(group);
        System.out.println(xml);
        GroupData gd = (GroupData) xs.fromXML(xml);

        for (Product product: gd.getProducts()) {
            System.out.println(product.getName());
        }

        for (OtherProduct otherProduct: gd.getOtherProducts()) {
            System.out.println(otherProduct.getId());
        }

    }

}