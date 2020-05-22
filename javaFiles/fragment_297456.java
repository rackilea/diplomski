public <U> Response getResponse(
    Request<U> studentRequest) {
    U studentRequestContext = 
      (U) studentRequest.getRequestContext();
    studentRequestContext.get //NO getName METHOD IS AVAILABLE 
}