RealmQuery<Email> query = realm.where(Email.class);
    query.contains(Email.PROPERTY_SUBJECT, queryString, Case.INSENSITIVE).or()
        .contains(Email.PROPERTY_SENDER_NAME, queryString, Case.INSENSITIVE).or()
        .contains(Email.PROPERTY_SENDER_EMAIL, queryString, Case.INSENSITIVE).or()
        .contains(Email.PROPERTY_BODY_CONTENT, queryString, Case.INSENSITIVE);
    RealmResults<Email> searchResults = query.findAllSorted(Email.PROPERTY_RECEIVED_DATE_TIME, Sort.DESCENDING);