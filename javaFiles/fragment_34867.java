AndroidApplicationRecord aar = new AndroidApplicationRecord();
aar.setPackageName("org.my.app");

Message message = new Message(); //  org.ndeftools.Message
message.add(androidApplicationRecord);
message.add(new GenericExternalTypeRecord("org.my.app", "username", myUsernameBytes);
message.add(new GenericExternalTypeRecord("org.my.app", "password", myPasswordBytes);

NdefMessage toWrite = highLevel.getNdefMessage();