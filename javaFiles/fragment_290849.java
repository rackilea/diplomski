private void sendHandshakeRequest(String key) throws IOException{

        pw.print("Upgrade: websocket" + LINE_SEPARATOR);
        pw.print("Connection: Upgrade" + LINE_SEPARATOR);
        pw.print("Sec-WebSocket-Key: " + key + LINE_SEPARATOR);
        pw.print("Sec-WebSocket-Protocol: mqttv3.1" + LINE_SEPARATOR);
        pw.print("Sec-WebSocket-Version: 13" + LINE_SEPARATOR);

        // TODO add the header with your token here