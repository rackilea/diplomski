PostMethod method = new PostMethod(url);
       method.addParameters("action", "find");
       method.addParameters("what", "somebody");

       int status = httpClient.executeMethod(method);
       byte[] bytes = method.getResponseBody();
       response = new String(bytes, "iso-8859-1");
       if (status != HttpStatus.SC_OK)
             throw new IOException("Status code: " + status + " Message: "
                                        + response);