UnsortedReadableList collection = new UnsortedReadableList();
Vector messages = new Vector();

// ApplicationMessageImpl is simple implementation of 
// net.rim.blackberry.api.messagelist.ApplicationMessage interface
messages.addElement(new ApplicationMessageImpl("bla-bla"));
Object[] messageArray = new Object[messages.size()];
messages.copyInto(messageArray));
collection.loadFrom(messageArray);