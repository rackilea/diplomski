class CustomPropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

    public void setFileName(String fileName) throws FileNotFoundException {
        File file = findPropertyFile(fileName);  // implement property file loading
        super.setLocation(new FileSystemResource(file));
    }