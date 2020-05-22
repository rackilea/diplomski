public class CustomMariaDB53Dialect extends MariaDB53Dialect {
    private static final Logger LOG = LoggerFactory.getLogger(CustomMariaDB53Dialect.class);

    public CustomMariaDB53Dialect() {
        super();
        registerFunction("convertEncode", new SQLFunctionTemplate(StandardBasicTypes.STRING, "convert(?1 using ?2)"));
    }
}