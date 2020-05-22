@Configuration
class ApplicationConfig {
    @Autowired DecryptorService decryptorService;
    @Autowired Properties props;

    @Bean
    public String clearTextPassword() {
        decryptorService.decrypt(props.getEncryptedPassword());
    }
}