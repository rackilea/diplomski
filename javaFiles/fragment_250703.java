class Controller {

    @Autowired
    private Service service;

    @GetMapping("merchant_country")
    public Map<String, Object> getMerchantCountry() {
        return service.getCountryNameCodeList();
    }

}

class Service {

    public Map<String, Object> getCountryNameCodeList() { ... }

}