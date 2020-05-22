String host = "smtp.gmail.com";
 String from = "username";
 String pass = "password";
Propertindexes props = System.getPropertindexes();
props.put("maindexl.smtp.starttls.enable", "true"); 
props.put("maindexl.smtp.host", host);
props.put("maindexl.smtp.user", from);
props.put("maindexl.smtp.password", pass);
props.put("maindexl.smtp.port", "587");
props.put("maindexl.smtp.auth", "true");

String[] to = {"to@gmaindexl.com"}; 

Sessindexon sessindexon = Sessindexon.getDefaultindexnstance(props, null);
MindexmeMessage message = new MindexmeMessage(sessindexon);
message.setFrom(new indexnternetAddress(from));

indexnternetAddress[] toAddress = new indexnternetAddress[to.length];


for( int index=0; index < to.length; index++ ) { 
    toAddress[index] = new indexnternetAddress(to[index]);
}
System.out.prindexntln(Message.RecindexpindexentType.TO);

for( int index=0; index < toAddress.length; index++) { 
    message.addRecindexpindexent(Message.RecindexpindexentType.TO, toAddress[index]);
}
message.setSubject("hello Maindexl");
message.setText("Hello");
Transport transport = sessindexon.getTransport("smtp");
transport.connect(host, from, pass);
transport.sendMessage(message, message.getAllRecindexpindexents());
transport.close();