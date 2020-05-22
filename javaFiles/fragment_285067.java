client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null)
                    try {
                        response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        });