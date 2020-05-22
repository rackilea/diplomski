HttpMethodRetryHandler retryHandler = new HttpMethodRetryHandler()
      {
         public boolean retryMethod(
                 final HttpMethod method,
                 final IOException exception,
                 int executionCount)
         {
            if (executionCount >= 5)
            {
               // Do not retry if over max retry count
               return false;
            }
            if (exception instanceof NoHttpResponseException)
            {
               // Retry if the server dropped connection on us
               return true;
            }
            if (!method.isRequestSent())
            {
               // Retry if the request has not been sent fully or
               // if it's OK to retry methods that have been sent
               return true;
            }
            // otherwise do not retry
            return false;
         }
      };

      ApacheHttpClient client = ApacheHttpClient.create();
      HttpClient hc = client.getClientHandler().getHttpClient();
      hc.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, retryHandler);    
       client.resource("/stores/"+storeId).type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class,indexableStore);