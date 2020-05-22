RetryTemplate retryTemplate = createRetryTemplate(3, 1000);
    return retryTemplate.execute(new RetryCallback<Object,Exception>() {
       @Override
       public Object doWithRetry(RetryContext context) throws Exception {
           userUpdateService.updateUser(userName, userID);
       }
    });