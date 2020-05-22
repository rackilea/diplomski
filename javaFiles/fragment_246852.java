FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
Message[] unreadMessages = emailFolder.search(unseenFlagTerm);
Address searchFrom = new InternetAddress("john@gmail.com");

for (int i = unreadMessages.length-1; i > 0 ; i--) {
    Message message = unreadMessages[i];

    if(Arrays.asList(message.getFrom()).contains(searchFrom)) {
        System.out.println("Subject : " + message.getSubject());
    }
}