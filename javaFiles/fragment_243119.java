List<String> zipCodes = ListUtils.mapObjectToField(contacts,
    new Mapper<Contact, String>() {
        public String map(Contact contact) {
            return contact.getZipCode();
        }
    });