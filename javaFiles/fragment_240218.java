public class SampleImpl implements Sample {
    @Inject WSClient ws;

    @Override
    public void callApi() {
        // ws should not be null
        ws.url("www.thomas-bayer.com/sqlrest/CUSTOMER/").get();
    }
}