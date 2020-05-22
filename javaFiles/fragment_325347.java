ListenableFuture listenable = service.submit(...);
    Futures.addCallback(listenable, new FutureCallback<Object>() {
                @Override
                public void onSuccess(Object o) {
                    //handle on success
                }

                @Override
                public void onFailure(Throwable throwable) {
                   //handle on failure
                }
            })