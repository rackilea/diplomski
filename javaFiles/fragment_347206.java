private RequestFactory requestFactory; // Change

public CheckRequestController(
        RequestService<CheckRequest, CheckResponse> checkRequestServiceImpl,
        RequestConfig requestConfig) {
    this.checkRequestServiceImpl = checkRequestServiceImpl;
    this.requestFactory = requestFactory; // Change
}