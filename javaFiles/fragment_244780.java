public void handleMessage(Message message) throws Fault {
       OutputStream os = message.getContent(OutputStream.class);
       StringBuilder responsePayload = new StringBuilder();
       CachedOutputStream cos = (CachedOutputStream) os;
       try {
               cos.writeCacheTo(responsePayload);
       } catch (IOException e) {
               e.printStackTrace();
       }
}