HttpRequest.Builder builder = new HttpRequest.Builder();
builder.setContext(context)
            .setRequestMethod(HttpRequest.RequestMethod.POST)
            .setBody(body)
            .setUrl("http://url")
            .run(YourResponeModel.class, new OnResponseCallback() {
                @Override
                public void onResponse(Object response) {
                },
               new OnFailureCallback() {
                    @Override
                    public void onFailure(Object throwable) {

                    }
            });