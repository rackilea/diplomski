public MailItem getNextMailItem(String who){
     MailItem mailItem = null;
     if (who != null && who.length() != 0){
        mailItem = mailbox.get(who).pollFirst();
     } 
     return mailItem;
}