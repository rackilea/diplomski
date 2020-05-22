public Person[] getAllPeopleAsPersonArray() {
    Cursor csr = getAllPeople();
    Person[] people = new Person[csr.getCount()];
    while (csr.moveToNext()) {
        people[csr.getPosition()] = new Person(
                csr.getLong(
                        csr.getColumnIndex(DBHelperPeople.ID_COL)
                ),
                csr.getString(
                        csr.getColumnIndex(DBHelperPeople.FORENAME_COL)
                ),
                csr.getString(
                        csr.getColumnIndex(DBHelperPeople.SURNAME_COL)
                )
                );
    }
    csr.close();
    return people;
}