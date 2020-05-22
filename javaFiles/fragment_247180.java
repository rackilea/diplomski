Ion.with(context)
            .load("http://" + SERVER + ":8080/upload")
            .progressDialog(pd)
            .setMultipartParameter("name", "source")
            .setMultipartFile("image", "image/jpeg", new File(imgPath))
            .asJsonObject()
            .setCallback(new FutureCallback<JsonObject>() {
                @Override
                public void onCompleted(Exception e, JsonObject result) {

                    //do stuff with result
                }
            });