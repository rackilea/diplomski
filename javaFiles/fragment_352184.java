RadioChoice<Long> rChoice = new RadioChoice<Long>("community_settings", new IModel<Long>() {
    public Long getObject() {
        if (user.getShowContactData() && user.getShowContactDataToContacts()) {
            return 1L;
        }
        // ...
    }

    public void setObject(Long choice) {
        if (choice == 1) {
            user.setShowContactData(true);
            user.setShowContactDataToContacts(true);
        } else if (choice == 2) {
            // ...
        }
    }

    public void detach() {
    }
}, choices);