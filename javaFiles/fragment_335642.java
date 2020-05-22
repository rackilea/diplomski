public MyResponse callUntilSuccess() {

    MyResponse response = myService.call();
    while (!response.isSuccessful()) {
        response = myService.call();
    }
    return response;
}