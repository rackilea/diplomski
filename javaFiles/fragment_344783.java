public class IDUpdater {
    private String difFilePath;
    private String outputDifPath;
    private String encoding;

    public void main(String[] args) throws Exception {
        processConfig();
        replaceID(); 
    }

    public void replaceID() throws Exception{
        // You can use your variables here.
        return record;
    }

    public void processConfig(){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");
        } catch (Exception e) {
            logger.error("File 'config.properties' could not be found.");
        }

        try {
            prop.load(input);
        } catch (Exception e) {
            logger.error("Properties file could not be loaded.");
        }

        difFilePath = prop.getProperty("dif_file_path");
        outputDifPath = prop.getProperty("output_dif_path");
        encoding = prop.getProperty("encoding");  
    }
}