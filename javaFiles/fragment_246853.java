FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
FromTerm fromTerm = new FromTerm(new InternetAddress("john@gmail.com"));
SearchTerm searchTerm = new AndTerm(unseenFlagTerm, fromTerm);

Message[] messages = emailFolder.search(searchTerm);

for (int i = messages.length-1; i > 0 ; i--) {
    System.out.println("Subject : " + message.getSubject());
}