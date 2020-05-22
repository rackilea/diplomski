emailsDatabase = Room.databaseBuilder(this,EmailsDatabase.class,"emailsdb")
                .allowMainThreadQueries()
                .build();

        ContactEntity c1 = new ContactEntity("email1","password","Fred");
        c1.setEmailTo("email1");
        ContactEntity c2 = new ContactEntity("email2","password","Mary");
        c2.setEmailTo("email2");
        ContactEntity c3 = new ContactEntity("email3","password","Jane");
        c3.setEmailTo("email3");
        emailsDatabase.contactsDao().insert(c1);
        emailsDatabase.contactsDao().insert(c2);
        emailsDatabase.contactsDao().insert(c3);
        emailsDatabase.emailsDao().insert(
                new EmailEntity(
                        "email1",
                        "email2",
                        "Blah",
                        "2019-12-31",
                        "10:30","filex",
                        false,
                        "This")
        );
        emailsDatabase.emailsDao().insert(
                new EmailEntity(
                        "email1",
                        "email3",
                        "Blah",
                        "2019-12-31",
                        "10:30","filex",
                        false,
                        "This")
        );
        emailsDatabase.emailsDao().insert(
                new EmailEntity(
                        "email2",
                        "email1",
                        "Blah",
                        "2019-12-31",
                        "10:30","filex",
                        false,
                        "This")
        );
        emailsDatabase.emailsDao().insert(
                new EmailEntity(
                        "email1",
                        "email2",
                        "Blah",
                        "2019-12-31",
                        "10:40","filex",
                        false,
                        "This")
        );
        List<EmailEntity> emailEntityList = emailsDatabase.emailsDao().getAllEmails();
        for (EmailEntity e: emailEntityList) {
            logEmail(e);
        }
        List<ContactEntity> contactEntityList = emailsDatabase.contactsDao().getAllContacts();
        for (ContactEntity c: contactEntityList) {
            logContact(c);
        }
        List<ContactWithEmailCounts> contactWithEmailCountsList = emailsDatabase.contactsDao().testit();
        for (ContactWithEmailCounts cwec: contactWithEmailCountsList) {
            Log.d("CWECINFO","Email Count = " + cwec.emailcount);
        }
    }

    private void logEmail(EmailEntity e) {
        Log.d("EMAIlINFO","Email From = " + e.getEmailFrom() + "Email To " + e.getEmailTo() + "Email Token = " + e.getEmailToken());
    }
    private void logContact(ContactEntity c) {
        Log.d("CONTACTINFO","Name = " + c.getContactName() + " Email = " + c.getEmailToken());
    }