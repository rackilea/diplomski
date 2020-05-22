properties.setProperty("mail.store.protocol", "imaps");
    properties.setProperty("mail.imaps.port", "993");
    Session session = Session.getDefaultInstance(properties);

    try {

        session = Session.getDefaultInstance(properties, null);

         javax.mail.Store store = session.getStore("imaps");


        store.connect("outlook.office365.com", "xyz", "xyz");
        Folder folderInbox = store.getFolder("james");
        folderInbox.open(Folder.READ_ONLY);