@Bean
public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("com.pb.service.ws.common", "com.pb.service.ws.delivery", "com.pb.service.ws.model");
    marshaller.setMtomEnabled(true);
    return marshaller;
}