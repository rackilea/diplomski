String send = "{\"AuditScheduleDetailID\":12422,\"AuditAnswerId\":3,\"LocalFindingID\":9," +
            "\"LocalMediaID\":18,\"Files\":\"adasdaf\",\"ExtFiles\":\"jpg\"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadMedia(send);
    }

    public void uploadMedia(String value) {
        Log.e("uploading ", "test");
        Log.e("Test value : ", value);
        String urlString = "myURL"; // URL to call

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();

            OutputStream out = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(URLEncoder.encode(value, "UTF-8"));
            writer.flush();
            writer.close();
            out.close();
            urlConnection.connect();
        } catch (Exception e) {
            Log.e("error upload", e.getMessage());
        }
    }