public class SourceCredentials implements KvmSerializable {

    //Xml variables
    private String sourceName;
    private String password;
    private SiteIDs siteIDs;


    public SourceCredentials(){
    }

    public setSourceName(String sourceName){
        this.sourceName = sourceName;
    }

    public String getSourceName(){
        return this.sourceName;
    }

    public setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public setSiteIDs(SiteIDs siteIDs){
        this.siteIDs = siteIDs;
    }

    public getSiteIDs(){
        return this.siteIDs;
    }

    @Override
    public Object getProperty(int index) {

        switch(index){
            case 0:
                return this.sourceName;
            case 1:
                return this.password;
            case 2:
                return this.siteIDs;
            default:
                break
    }

    @Override
    public int getPropertyCount() {
        return 3;


    @Override
    public void setProperty(int index, Object value) {
        switch(index){
            case 0:
                this.sourceName = value.toString();
                break;
            case 1:
                this.password = value.toString();
                break;
            case 2:
                this.siteIDs = (SiteIDs) value;                    
                break;
        }

    }

    @Override
    public void getPropertyInfo(int index, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (index){
            case 0:
                propertyInfo.name = "SourceName";
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                break;
            case 1:
                propertyInfo.name = "Password";
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                break;
            case 2:
                propertyInfo.name = "SiteIDs";
                propertyInfo.type = PropertyInfo.OBJECT_CLASS;
                break;
            default:
                break;
        }
    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }