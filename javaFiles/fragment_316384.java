public class Config {

    private Long id;
    private ConfigService service;

    public Config(Long id) {
        this.id = id;
    }

    public void setConfigService(ConfigService configService){
        this.service=configService;
    }

    public String callingService() {
        String result = this.service.getId(id);
        System.out.println("result = " + result + " for id: " + id);
        return result;
    }
}