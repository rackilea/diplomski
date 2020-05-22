Date someDate = new Date();

FriendlyMessage friendlyMessage = new FriendlyMessage("bla","bla","bla");

 String key = mFirebaseDatabaseReference.child(MESSAGES_CHILD).push().getKey();
 Map<String, Object> postValues =  friendlyMessage.toMap();
 postValues.put("creationDate", ServerValue.TIMESTAMP);
 childUpdates.put("/"+MESSAGES_CHILD+"/" + key, postValues);
 Map<String, Object> childUpdates = new HashMap<>();

 mFirebaseDatabaseReference.updateChildren(childUpdates);