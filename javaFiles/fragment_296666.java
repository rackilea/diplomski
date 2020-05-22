public class RegisterServices {
    /*
     * You must use @Resource instead of @Autowire 
     * https://jira.spring.io/browse/SPR-8450
     * (and of course you need to enable @Resourse support first)
     */
    @Resource private RegisterServices self; //self reference with proxy
    ...

    public Response create(...) {
        this.self.createUser(...);
    }

    @LogPerformance
    public ClientRespWsBean createUser(...){...}
}