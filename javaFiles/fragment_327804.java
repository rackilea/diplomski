public class HttpRequest<M extends BaseModel> extends AsyncTask<Object, Integer, M> {
public enum RequestMethod {
    GET("GET"), POST("POST");

    private final String requestMethod;

    RequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getValue() {
        return requestMethod;
    }
}

    private Context context = null;
    private String url;
    private OnResponseCallback onResponseCallback;
    private OnFailureCallback onFailureCallback;
    private RequestMethod method;
    private int statusCode;
    private String message;
    private Class<M> responseModel;
    private Object body = null;
    private String token;

    private HttpRequest() {

    }

    @Override
    protected M doInBackground(Object... voids) {
        try {
             HttpURLConnection connection = getHttpConnection();
             connection.connect();

            int statusCode = connection.getResponseCode();
            if (connection.getResponseCode() / 100 != 2) {
                this.statusCode = statusCode;
                this.message = connection.getResponseMessage();
                return JsonParser.getErrorBodyAs(responseModel, statusCode, 
message);
            }

            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            return JsonParser.getErrorBodyAs(responseModel, statusCode, 
convertInputStreamToString(streamReader));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpURLConnection getHttpConnection() throws IOException {
        URL url = new URL(this.url);

        HttpURLConnection connection = (HttpURLConnection) 
 url.openConnection();
        connection.setRequestMethod(method.getValue());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setReadTimeout(30000);
        connection.setConnectTimeout(30000);

    if (method == RequestMethod.POST) {
        connection.setDoInput(true);
        connection.setDoOutput(true);

        if (body != null) {
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(new Gson().toJson(body));
            writer.flush();
        }
    }

    return connection;
}

@Override
protected void onPostExecute(M m) {
    if (m == null) {
        if ((message != null && !message.equals("") && statusCode != 0)) {
            HttpException httpException = new HttpException(statusCode, message);
            onFailureCallback.onFailure(httpException);
        } else {
            onFailureCallback.onFailure("unknown error");
        }
    } else {
        onResponseCallback.onResponse(m);
    }
}

public static String convertInputStreamToString(InputStreamReader inputStreamReader) throws IOException {
    if (inputStreamReader == null) {
        return "";
    }

    BufferedReader reader = new BufferedReader(inputStreamReader);
    StringBuilder stringBuilder = new StringBuilder();

    String inputLine;
    String result;

    while ((inputLine = reader.readLine()) != null) {
        stringBuilder.append(inputLine);
    }

    reader.close();
    inputStreamReader.close();
    return stringBuilder.toString();
}

static public class Builder {
    HttpRequest t = new HttpRequest();

    public Builder setContext(Context context) {
        t.context = context;
        return this;
    }

    public Builder setUrl(String url) {
        t.url = url;
        return this;
    }

    public Builder setRequestMethod(RequestMethod method) {
        t.method = method;
        return this;
    }

    public Builder setBody(Object body) {
        t.body = body;
        return this;
    }

    public Builder setToken(String token) {
        t.token = token;
        return this;
    }

    public HttpRequest get() {
        return t;
    }

    public HttpRequest run(Class<?> responseTypeClass,
                           OnResponseCallback onResponseCallback,
                           OnFailureCallback onFailureCallback) {
        t.responseModel = responseTypeClass;
        t.onResponseCallback = onResponseCallback;
        t.onFailureCallback = onFailureCallback;
        t.execute();
        return t;
    }

    public Builder() {
    }
 }
}