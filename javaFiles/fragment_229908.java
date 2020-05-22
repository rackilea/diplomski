HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", "JSESSIONID=" + sessionId);

        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);

        String controllerUrl = CONTROLLER_URL;
        ListenableFuture<ResponseEntity<String>> responseEntityListenableFuture = restTemplate.exchange(controllerUrl, HttpMethod.GET, httpEntity, String.class);

        responseEntityListenableFuture.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            @Override
            public void onSuccess(ResponseEntity<String> stringResponseEntity) {
                // Nothing to do
            }

            @Override
            public void onFailure(Throwable throwable) {
                // Handle your error
            }
        });