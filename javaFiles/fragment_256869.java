private String getSourceIp() {
    if (request!= null && request.getHeader("X-Forwarded-For") != null) {
      return request.getHeader("X-Forwarded-For");
    } else {
      return "0.0.0.0"; //or you can throw an error depending on how you want to handle it.
    }
  }