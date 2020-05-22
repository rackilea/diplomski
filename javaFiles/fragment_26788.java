public abstract class SoapURL {
    public String getNameSpace() {
        return "https://host.com/AndroidWFC/";
    }
    public String getUrl() {
       return "https://host.com/AndroidWFC/MobileWS.asmx";
    }

    public abstract String getSoapAction();
    public abstract String getMethodName();
}