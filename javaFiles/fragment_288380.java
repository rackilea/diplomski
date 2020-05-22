public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

public static final String ANY_PROPERTY = "ANY_PROPERTY";

private static final Log LOG = LogFactory.getLog(MyPropertyPlaceholderConfigurer.class);

@Override
protected void loadProperties(Properties props) throws IOException {

    String anyProperty = System.getProperty(ANY_PROPERTY);

    if (StringUtils.isEmpty(anyProperty)) {
        LOG.info("Using default configuration");
        super.loadProperties(props);

    } else {
        LOG.info("Setting HDFS LOCATION PATH TO : " + anyProperty);

        try {
            Path pt = new Path(anyProperty);
            Configuration conf = new Configuration();
            conf.set(FileSystem.FS_DEFAULT_NAME_KEY, anyProperty);
            FileSystem fs = FileSystem.get(conf);
            FSDataInputStream fileOpen = fs.open(pt);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileOpen));
            props.load(br);
        } catch (Exception e) {
            LOG.error(e);
        }
    }

}