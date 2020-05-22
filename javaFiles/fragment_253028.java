Socket clientSocket = serverSocket.accept();
byte[] receiveBuffer = new byte[Test.RECEIVE_BUFFER_LENGTH];
InputStream bufferedInputStream = new BufferedInputStream(clientSocket.getInputStream());
while (true) {
    int readBytes = bufferedInputStream.read(receiveBuffer);
    System.out.println("readBytes: " + readBytes); // Here I am getting 9 then -1.
    if (readBytes < 0) {
        break;
    }
    // Here you need to process `receiveBuffer[0..readBytes-1],
    //  and note that it may not contain a complete message,
    // so you may have to do more reading.
    // ...
    // after ending the processing send a reponse to the Android app.

    try {
        byte[]    answerBuffer = {0x00};
        clientSocket.getOutputStream().write(answerBuffer);
        System.out.println("Sent answer to the client");
    } catch (IOException e) {
            e.printStackTrace();
    }
}
clientSocket.close();