@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    private ImportHandler monographImportHandler;

    @Autowired
    private ImportHandler periodicalImportHandler;

    @Bean(name = "importHandlerCatalog")
    @Scope("prototype")
    public Map<MetsFileType, ImportHandler> sipPackageProcessorCatalog() {
        Map<MetsFileType, ImportHandler> catalog = new HashMap<>();
        catalog.put(MetsFileType.MONOGRAPH, monographImportHandler);
        catalog.put(MetsFileType.PERIODICAL, periodicalImportHandler);
        return catalog;
    }

}