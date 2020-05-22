public class Task implements Callable<DataResponse> {

    private DataKey key;

    private ThreadLocal<RestTemplate> restTemplateThreadLocal =
            ThreadLocal.withInitial(()->new RestTemplate(new SimpleClientHttpRequestFactory()));

    public Task(DataKey key) {
        this.key = key;
    }

    private SimpleClientHttpRequestFactory getConnectionFactory(){
        return (SimpleClientHttpRequestFactory)restTemplateThreadLocal.get().getRequestFactory();
    }

    @Override
    public DataResponse call() {
        DataResponse dataResponse = null;
        String response = null;

        try {
            String url = createURL();
            //it is up to you, how to set connection and read timeouts from provided key.getTimeout
            getConnectionFactory().setConnectTimeout(1000);
            getConnectionFactory().setReadTimeout(key.getTimeout());
            response = restTemplateThreadLocal.get().getForObject(url, String.class);

            // it is a successful response
            dataResponse = new DataResponse(response, DataErrorEnum.NONE, DataStatusEnum.SUCCESS);
        } catch (RestClientException ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.SERVER_DOWN, key);
            dataResponse = new DataResponse(null, DataErrorEnum.SERVER_DOWN, DataStatusEnum.ERROR);
        } catch (Exception ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.CLIENT_ERROR, key);
            dataResponse = new DataResponse(null, DataErrorEnum.CLIENT_ERROR, DataStatusEnum.ERROR);
        }

        return dataResponse;
    }

    // create a URL by using key object
    private String createURL() {
        String url = somecode;
        return url;
    }
   }