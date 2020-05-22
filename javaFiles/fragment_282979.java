<% response.setStatus(301);
   response.setHeader("Location", "http://www.example.com" + request.getRequestURI() +
      (request.getQueryString() == null
          ? ""
          : ("?" + request.getQueryString())
      ));
   response.setHeader("Connection", "close"); %>