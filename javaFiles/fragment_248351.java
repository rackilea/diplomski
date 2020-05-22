// to be used to update UI in UI thread
private Handler mHandler;


@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(org.stmarcus.stmarcusmke.R.layout.fragment_giving, container, false);

    final WebView mWebView = view.findViewById(org.stmarcus.stmarcusmke.R.id.giving_webview);

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(calendarJSON)
            .build();

    // instantiate mHandler
    mHandler = new Handler(Looper.getMainLooper());

    Call call = client.newCall(request);
    call.enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call,Response response) throws IOException {

            try {
                String jsonData = response.body().string();
                if (response.isSuccessful()) {
                    CalendarHelper data = Converter.fromJsonString(jsonData);
                    ObjectElement[] objects = data.getObjects();
                    postcontent = objects[0].getPostBody();
                    Log.v(TAG, postcontent.toString());

                    // update UI in UI Thread
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (postcontent.isEmpty()) {
                                Log.v(TAG, "empty");
                                mWebView.loadDataWithBaseURL(null, postTest, "text/html", "utf-8", null);

                            } else {
                                mWebView.loadDataWithBaseURL(null, postcontent, "text/html", "utf-8", null);

                                Log.v(TAG, "not empty");
                            };
                        }
                    });

                } else {
                    //alertUserAboutError();
                }
            } catch (IOException e) {
                Log.v(TAG, "Exception caught : ", e);
            }
        }
    });