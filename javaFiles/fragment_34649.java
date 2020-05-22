/**
 * Quick echo test code.
 * @param args
 */
public static void main(String[] args) {
    try {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("key1", "value1");
        headers.put("key2", "value2");

        WebSocket ws = new WebSocket(new URI("ws://localhost:8080/echo"));
        ws.setHeaders(headers);
        ws.connect();

        String request = "Hello";
        ws.send(request);
        String response = ws.recv(); 
        System.out.println(request);
        if (request.equals(response)) {
            System.out.print("Success!");
        } else {
            System.out.print("Failed!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}