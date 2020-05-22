mcityService.authLogin(request, Utils.prepareHeaders())
            .concatMap(response -> { 
               final Map<String, String> headers = Utils.prepareHeaders(resp.tokenType,resp.accessToken);
               return mcityService.getUserDetails(selectedCity.id, headers)
                                  .map(userDetails -> ResponseUserDetails.of(response, userDetails));
            })
            .doOnNext(responseDetails -> {
               // Hanlde ResponseUserDetails object
            })
            .doOnError(throwable -> {
               // Handle exception
               final String message = throwable.getMessage();
               ...
            })
            .subscribe(
               responseDetails -> { ... },
               throwable -> { ... }
            );