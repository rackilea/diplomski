String URL_PREFIX = "myurl";

for(int i = 0; i < 5; i++) {
    PUT_URL = URL_PREFIX + i + 1;
    System.out.println(PUT_URL);
    sendPUT();
    System.out.println("PUT Done");
}