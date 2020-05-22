String message = "Hi Sign ME!!!";
s.update(message.getBytes("UTF8");
byte[] signature = s.sign()

oos.writeObject(message);
oos.writeObject(signature);