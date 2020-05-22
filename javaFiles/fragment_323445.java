public void EditList(User user)
{

        db = this.getWritableDatabase();
        db.execSQL( "UPDATE " + TABLE_USER + " SET " + DOLIST + "='" + user.getDoList() + "' WHERE " +  USERNAME + " LIKE "+"'"+user.getUsername()+"'");

}