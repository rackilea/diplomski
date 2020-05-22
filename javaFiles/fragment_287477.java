Multipart multipart = (Multipart) message.getContent();
for (int j = 0; j < multipart.getCount(); j++) {
BodyPart bodyPart = multipart.getBodyPart(j);
System.out.println("Body: "+bodyPart.getContent());
content= bodyPart.getContent().toString();
System.out.println(content);
}