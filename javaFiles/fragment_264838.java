import java.net.ProxySelector;
...

public static void main(String[] args) throws Exception {

    // get default proxy before soapui will set it to null
    ProxySelector proxy = ProxySelector.getDefault();

    SoapUIRun srun = new SoapUIRun();
    srun.runTestCase("CPIHS", "CPIHS");

    // set it again to avoid NPE on selenium
    ProxySelector.setDefault(proxy);

    new MainPage().LoginCad();
}