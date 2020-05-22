public Cursor getAppointmentsData() {
    String[] columns = new String[] { KEY_ROWAPPID, KEY_NAMEAPP,
            KEY_TYPEAPP, KEY_TIMEAPP, KEY_DATEAPP, KEY_COMMENTAPP };
    return ourDatabase.query(DATABASE_TABLEAPP, columns, null, null,
            null, null, KEY_NAMEAPP + " ASC", null);
}