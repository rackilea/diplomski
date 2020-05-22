MessageQueue queue = new MessageQueue(system, "/qsys.lib/qsysopr.msgq");

// want only inquiry messages
queue.setSelectMessagesNeedReply(true);
queue.setSelectMessagesNoNeedReply(false);
queue.setSelectSendersCopyMessagesNeedReply(true);

Enumeration e = queue.getMessages();