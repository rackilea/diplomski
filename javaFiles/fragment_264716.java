boolean quit = false;
while (!quit) {
    sentence = this.inUser.readLine();
    quit = sentence.trim().equals("quit");
    this.out.writeBytes(sentence + '\n');
    modifiedSentence = this.inServeur.readLine();
    System.out.println("FROM SERVER: " + modifiedSentence);
}
this.socket.close();