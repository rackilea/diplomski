@Service
public class Demo{
    @Autowired
    public ApplicationContext appContext;
    public CurrencyConverterService currencyConverterService;

    public void getCurrencyFromAPI(Object value, String targetCurrCode, String baseCurrCode){
        ....
        currencyConverterService = (CurrencyConverterService) appContext.getBean("currencyConverterService");
        currencyConverter(value, targetCurrCode, baseCurrCode);
        ....

    }

    public BigDecimal currencyConverter(Object value, String targetCurrCode, String baseCurrCode){
        float rate;

        if (baseCurrCode.equals(targetCurrCode)){
            rate = 1.0f;
        }else{
            rate = currencyConverterService.getCurrencyRate(targetCurrCode, baseCurrCode);
        }
        return ((BigDecimal)value).multiply(new BigDecimal(rate));
    }

}