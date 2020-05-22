public class PropertiesFactoryBean implements FactoryBean<Properties>{

    public void setPropertiesResource(Resource propertiesResource){
        this.propertiesResource = propertiesResource;
    }

    private Properties value=null;
    long lastChange = -1L;

    private Resource propertiesResource;

    @Override
    public Properties getObject() throws Exception{
        synchronized(this){
            long resourceModification = propertiesResource.lastModified();
            if(resourceModification != lastChange){
                Properties newProps = new Properties();
                InputStream is = propertiesResource.getInputStream();
                try{
                    newProps.load(is);
                } catch(IOException e){
                    throw e;
                } finally{
                    IOUtils.closeQuietly(is);
                }
                value=newProps;
                lastChange= resourceModification;
            }
        }
        // you might want to return a defensive copy here
        return value;
    }

    @Override
    public Class<?> getObjectType(){
        return Properties.class;
    }

    @Override
    public boolean isSingleton(){
        return false;
    }

}