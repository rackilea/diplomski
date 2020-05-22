String time = received.split("\\|\\|")[0];
String msgToSend = received.split("\\|\\|")[1];
//Instead of doing this, its better to do this: 
String peices[]=received.split("\\|\\|");
String msgToSend=peices[1];
String time=peices[0]