@Override
        protected Void doInBackground(Integer... integers) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://thebeerguru.byethost13.com/conn_all.php?id="+id)
                    .addHeader("Cookie", "__test=THE_CONTENT_OF_MY_COOKIE; expires=Thu, 31-Dec-37 23:55:55 GMT; path=/")
                    .build();

            try {
                Response response = client.newCall(request).execute();

                JSONArray array = new JSONArray(response.body().string());