@Service
public class CurrencyConverterService {
    private Logger log = LogManager.getLogger(CurrencyConverterService.class);
    @Autowired
    private ICurrencyService currencyService;

    int counter=0;

    @Cacheable(value = "allCurrency")
    public Float getCurrencyRate(String targetCurrCode, String baseCurrCode){
        log.error("getCurrencyRate called " +targetCurrCode +" - "+baseCurrCode+" - counter "+ counter+" Times");
        counter++;
        Float rate = currencyService.calculateParity(targetCurrCode, baseCurrCode);
        return rate;
    }
}