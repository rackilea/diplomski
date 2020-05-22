Folder inbox = store.getFolder("inbox");
inbox.open(Folder.READ_ONLY);
// search for all "unseen" messages
Flags seen = new Flags(Flags.Flag.SEEN);
FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
Message messages[] = inbox.search(unseenFlagTerm);


if (messages.length == 0) System.out.println("No messages found.");