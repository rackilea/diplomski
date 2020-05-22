final Socket echoSocket = new Socket("taranis", 7);
try {
    ... something ...
} finally {
    echoSocket.close();
}