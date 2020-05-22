callbackExecutor.execute(new Runnable() {
                    @Override
                    public void run() {

                        int code = response.code();
                        if (code >= 200 && code < 300) {
                            callback.success(response);
                        } else if (code == 401) {
                            callback.unauthenticated(response);
                        } else if (code >= 400 && code < 500) {
                            callback.clientError(response);
                        } else if (code >= 500 && code < 600) {
                            callback.serverError(response);
                        } else {
                            callback.unexpectedError(new RuntimeException("Unexpected response " + response));
                        }
                    }
                });