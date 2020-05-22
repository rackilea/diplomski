public String sayHello(String who) {
    byte[] message = translateMethodCallToBytes("sayHello", who);
    byte[] response = sendMessageToServer(message);
    String result = extractReturnValueFromResponse(response);
    return result;
}