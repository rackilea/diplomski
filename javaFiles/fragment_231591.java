// added bonus types
Table userBonus = realm.getTable(UserBonus.class);
userBonus.addColumn(ColumnType.STRING, "localId");
userBonus.addColumn(ColumnType.INTEGER, "type");
userBonus.addColumn(ColumnType.INTEGER, "date");
userBonus.addColumn(ColumnType.STRING, "userName");
userBonus.addColumn(ColumnType.STRING, "userNumber");
userBonus.addColumn(ColumnType.STRING, "credits");

// move Gift to UserBonus
RealmResults<Gift> gifts = realm.where(Gift.class).findAll();
for (Gift gift :gifts) {
    userBonus.add(
            gift.getLocalId(),
            UserBonus.TYPE_FRIEND,
            gift.getDate(),
            gift.getUserName(),
            gift.getUserNumber(),
            gift.getCredits()
    );
}
realm.where(Gift.class).findAll().clear();