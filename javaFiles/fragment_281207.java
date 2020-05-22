public class ThisApp extends Application {

    private static TipBeanApi tipApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        buildCloudEndpoints();
    }

    private void buildCloudEndpoints() {
        TipBeanApi.Builder builder = new TipBeanApi.Builder(AndroidHttp.newCompatibleTransport(),
        new AndroidJsonFactory(), null)
            .setRootUrl("http://10.0.2.2:8080/_ah/api/").setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {@Override
            public void initialize(AbstractGoogleClientRequest <? > abstractGoogleClientRequest) throws IOException {
                abstractGoogleClientRequest.setDisableGZipContent(true);
            }
        });

        tipApiService = builder.build();
    }

    public static TipBeanApi getApiService() {
        return tipApiService;
    }

}