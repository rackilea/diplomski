class Singleton {
    private static Singleton instance;
    private Properties xmlProperties;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Properties getXmlProperties() {
        if(xmlProperties == null) {
            initProperties();
        }
        return xmlProperties;
    }

    private synchronized void initProperties() {
        if(xmlProperties == null) {
            //Initialize the properties from Xml properties file
            // xmlProperties = (Properties from XML file)
        }
    }
}