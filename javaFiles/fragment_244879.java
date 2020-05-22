public static final Uri DB_TABLE_TEAM_URI = Uri
        .parse("sqlite://" + Constants.ApplicationPackage + "/" + DB_TABLE_TEAM);

public boolean addNewTeam(Team team){
    ContentValues contentValues = new ContentValues();

    contentValues.put(KEY_NAME, team.getName());
    contentValues.put(KEY_CODE, team.getCode());

    boolean success = db.insert(TABLE_NAME, null, contentValues) > 0;
    context.getContentResolver().notifyChange(DBConstants.DB_TABLE_TEAM_URI, null);
    return success;
}