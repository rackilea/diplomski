out.writeUTF("Server ready");
out.flush();
// If we are here, then connection was probably not a portscan
out.writeObject(tfList);
out.writeObject(multipleList);
out.flush();
clientAnswers = (List<String>) in.readObject();
out.writeInt(checkAnswers());
out.writeUTF("Bye");
out.flush();