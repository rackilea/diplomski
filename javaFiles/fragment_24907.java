@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @MockBean
    private ProductRepository repository;

    @Autowired
    private ProductService productService;

    @Test
    public void test() {

        Mockito.when(repository.findProductByName(Mockito.anyString())).thenReturn(new Product());

        boolean result = productService.checkIfProductExists("some product name");

        assertEquals(true, result);
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        public ProductService productService(final ProductRepository repository) {

        return new ProductService(repository);
        }
    }
}