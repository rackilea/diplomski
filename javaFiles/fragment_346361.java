@Service
public class ProductToDisplayService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private LanguageRepository languageRepository;

    public ProductToDisplay getProduct(long productID, long languageID, long deviceID) throws Exception {
        Product product =
                productRepository.findById(productID).orElseThrow(()-> new Exception(
                        "There is no such product"));

        return new ProductToDisplay(product,
                productInfoRepository.findByProductAndLanguage(product,
                        languageRepository.findById(languageID).orElseThrow(()-> new Exception(
                                "There is no such product"))).orElseThrow(()-> new Exception(
                        "There is no such product info")).getDescription(),
                productImageRepository.findByProductAndDevice(product,
                        deviceRepository.findById(deviceID).orElseThrow(()-> new Exception(
                                "There is no such product"))).orElseThrow(()-> new Exception(
                        "There is no such product Image")).getImage());
    }
}