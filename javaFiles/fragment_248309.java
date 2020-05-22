String serverReady = in.readUTF();
tfList = (List<TrueFalse>) in.readObject();
multipleList = (List<Multiple>) in.readObject();
out.writeObject(userAnswers);
out.flush();
// wait for server to check answers and return score
int returned_score = in.readInt();
String serverBye = in.readUTF();
// server has processed score and send "Bye".