public List<message> split(Exchange exchange){
      InputStream iStream = (InputStream) exchange.getIn().getBody();
      File file = new File("tmp/filename.jpg");
      FileUtils.copyInputStreamToFile(iStream, file);

      List<File> files = <your splitting logic method>

      List<Message> messageList = new ArrayList<Message>();
      for (File file : files) {
           DefaultMessage message = new DefaultMessage(); 
           InputStream ip = new FileInputStream(file.getName());
           message.setBody((InputStream) ip);
           messageList.add(message);
    }
    return messageList;
}