@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductTest {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProductService productService;

    @Test
    public void testProductFinal() throws ParseException {
        Product product = new Product();
        product.setId(1);
        product.setManufacturedDate(SDF.parse("2016-08-08 01:01:01"));
        product.setPrice(200);
        product.setProductCode("AZ0100");
        product.setProductName("Lenovo Vibe X3");
        product.setVat(5.64F);

        productService.create(product);
    }

    @Test
    public void testFindByProductCode(){
        Product product = productService.findByProductCode("AZ00010");
        System.out.println("----------------------------------------");
        System.out.println("ManufacturedDate  : "+product.getManufacturedDate());
        System.out.println("Price             : "+product.getPrice());
        System.out.println("ProductCode       : "+product.getProductCode());
        System.out.println("Product Name      : "+product.getProductName());
        System.out.println("Vat               : "+product.getVat());
    }
}