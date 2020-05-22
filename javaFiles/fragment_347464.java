SomeClass1 instance        = FirebaseDatabase.getInstance();
SomeClass2 reference       = instance.getReference();
SomeClass3 push            = reference.push();
SomeClass4 authInstance    = FirebaseAuth.getInstance();
SomeClass5 currentUser     = authInstance.getCurrentUser();
SomeClass6 displayName     = currentUser.getDisplayName();
SomeClass6 message         = input.getText();
SomeClass7 messageAsString = message.toString();
SomeClass8 chatMessage     = new ChatMessage(messageAsString, displayName);

push.setValue(chatMessage);