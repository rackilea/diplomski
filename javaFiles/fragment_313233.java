public long getProfilesRecordCount(String profileName)
{
 SQLiteDatabase db=this.openReadable(); 
long rawNum=DatabaseUtils.queryNumEntries(db,TABLE_NAME,"Profile_Name=?", new String[]{profileName});
 return rawNum; 
}