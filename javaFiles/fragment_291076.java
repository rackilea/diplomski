builder.sendRequest(null, new RequestCallback() {

            public void onError(Request request, Throwable exception) {
                GWT.log(exception.getMessage());
            }

            public void onResponseReceived(Request request, Response response) {
                newMethod(processResponse(response));
            }
        });