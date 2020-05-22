public class YourBean {

    //Also, you can use #{param['market']} as the value of the ManagedProperty        
    @ManagedProperty(value = "#{param.market}")
    private Long market;

    public void setMarket(Long market) {
        this.market = market;
    }

}