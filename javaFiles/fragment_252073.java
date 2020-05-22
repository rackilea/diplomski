JAXBContext con = JAXBContext.newInstance(Xmeml.class);
File dir = new File("D:\\Temp\\schema");
con.generateSchema(new MySchemaOutputResolver(dir));

class MySchemaOutputResolver extends SchemaOutputResolver {

    protected File baseDir;

    public MySchemaOutputResolver(File dir)
    {
        super();
        baseDir =  dir;
    }

    @Override
    public Result createOutput( String namespaceUri, String suggestedFileName ) throws IOException {
        return new StreamResult(new File(baseDir,suggestedFileName));
    }
}