@ManagedBean
@ViewScoped
public class MyBean {
    private String data;
    //getter and setter for data
    public void foo() {
        ThirdPartyLibraryClass tplc = new ThirdPartyLibraryClass();
        tplc.bar(data);
    }
}