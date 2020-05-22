@Bean 
public Docket plugin() {
    new Docket()
        //more config
        .pathMapping("/rest");

}