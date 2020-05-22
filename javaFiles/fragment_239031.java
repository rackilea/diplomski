ApiResponse apiResponse = null;
try {
    apiResponse = apiService.CallApi(apiURL, requestObject);
    boolean apiStatus = getApiStatus(apiResponse);
} catch (ApiException ex) {
    handleApiException(ex);
}