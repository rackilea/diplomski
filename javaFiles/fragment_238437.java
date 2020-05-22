public class UILabels extends ResourceBundle {


private ResourceBundle getFileResources(){
    return ResourceBundle.getBundle("com.example.web.UILabelsFile", this.getLocale());
}

public Enumeration<String> getKeys() {
    return getFileResources().getKeys();
}

protected Object handleGetObject(String key) {
    if(overrideValue(key)){
        return getOverridenValue(key);
    }
    return getFileResources().getObject(key);
}

}