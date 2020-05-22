handleJavaSocket(Socket javasocket){
  // echo socket
  javasocket.transform(UTF8.decoder).forEach((item) {
    var start = 2;
    var end = -1;
    var messages = new List<String>();
    while((++end < item.length) && (end = item.indexOf('}',end)) != -1) {
      messages.add(item.substring(start, ++end));
      start = end + 2;
    }
    for(var message in messages) {
      // header message length as two bytes
      javasocket.writeCharCode(0); // max length 254
      javasocket.writeCharCode(message.length); 
      javasocket.write(message); // <== send
    }
  });

}