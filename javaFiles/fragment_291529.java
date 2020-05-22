//In Activity
realm.executeTransaction(new Realm.Transaction() {
    @Override
    public void execute(Realm realm) {
        Contact contact = realm.where(Contact.class)
                               .equalTo("name","pete")
                               .findFirst();
        if(contact != null) {
            UpdateHelper.update(contact, realm);
        }
    }
});

//helper method
public static void update(Contact contact, Realm realm) {
    //do update stuff
    Email email = realm.copyToRealm(new Email());
    contact.getEmails().add(email);
}