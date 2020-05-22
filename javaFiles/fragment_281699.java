public MailItem getNextMailItem(String who) {
    MailItem mailItem = null;
      if (who != null && who.length() != 0){
         mailbox.get(who).pollFirst();
      } else {
         mailItem = MailItem.NULL_ITEM;
      }
     return mailItem;
}