FindItemsResults<Item> result = service.findItems(new FolderId(WellKnownFolderName.Inbox, new Mailbox(getCredentials())), getUnreadEmailFilter(), new ItemView(10));
result.forEach(n -> {
    if (n instanceof MeetingRequest) {
       System.out.println("New Appointment - MeetingRequest found!");
       MeetingRequest req = (MeetingRequest) n;
       req.accept(true);
    }
}