@Component
public class MyBean {
    private String xmlFile;
    private String xsdFile;

    @Autowired
    public MyBean(@Value("$MYDIR/myfile.xml") final String xmlFile,
            @Value("$MYDIR/myfile.xsd") final String xsdFile) {
        this.xmlFile = xmlFile;
        this.xsdFile = xsdFile;
    }

    //methods
}