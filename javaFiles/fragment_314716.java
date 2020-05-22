@Mock
private InitialData initialData;

@InjectMocks
private ProductRepositoryOffline pro;

@Test
public void testPersistProduct() {
    Product product = new Product(0, "", "", "", 0.0, true, "", 0,
        /*Product type*/null, "", 0, 0);
    ArrayList<Product> productList = new ArrayList<Product>();    
    productList.add(product);

    Mockito.when(initialData.getProducts()).thenReturn(productList);
    pro.persistProduct(product);
    assertEquals(pro.getProducts().get(0), product);
    Mockito.verify(initialData).addProduct(product);
}