String TableName = "UserInfo";
public static final String col1 = UserProfile.users._ID;
public static final String col2 = UserProfile.users._UserName;
public static final String col3 = UserProfile.users._DOB;
public static final String col4 = UserProfile.users._Gender;
public static final String col5 = UserProfile.users._Password;

public DBHelper(Context context) {
    super(context, "database", null, 1);
}

@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TableName + " ("+col1+" integer primary key autoincrement, "+col2+" text,"+col3+ " text,"+col4+" text,"+col5+" text)");
}

@Override
public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists "+ TableName);
    onCreate(db);
}

public boolean addInfo(String name,String dob, String gender,String password){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv=new ContentValues();
    cv.put(col2,name);
    cv.put(col3,dob);
    cv.put(col4,gender);
    cv.put(col5,password);
    int i =(int) db.insert(TableName,null,cv);
    db.close();
    if(i>0){
        return  true;
    }else{
        return false;
    }
}

public boolean updateInfor(int id,String name,String dob, String gender,String password){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv=new ContentValues();
    cv.put(col2,name);
    cv.put(col3,dob);
    cv.put(col4,gender);
    cv.put(col5,password);
    int i = db.update(TableName,cv,col1+"=\""+ id + "\"",null);
    db.close();
    if(i>0){
        return  true;
    }else{
        return false;
    }
}

public Cursor readAllinfor(){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cs = db.rawQuery("select * from "+TableName+"",null);
    db.close();
    return  cs;
}

public Cursor readAllinfor(int id){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cs = db.rawQuery("select * from "+TableName+" where "+col1+"=\""+id+"\"",null);
    db.close();
    return  cs;
}

public boolean deleteInfo(int id){
    SQLiteDatabase db = this.getWritableDatabase();
    int i= db.delete(TableName,col1+"=\""+id+"\"",null);
    db.close();
    if(i>0){
        return  true;
    }else{
        return false;
    }