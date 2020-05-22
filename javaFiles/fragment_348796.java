private int mMinutes = 145;
protected void ScheduleOp1() {
    Cursor cur = null;
    boolean mustContinue = true  ;
    while(mustContinue){
         db.execSQL("DROP VIEW IF EXISTS " +view_Schedule1);
    db.execSQL("CREATE VIEW " +view_Schedule1+ " " +
            " AS SELECT " +sBusDepart+ "," +sBusArrival+ "," 
            +sBusDepartT+ "," +sBusArrivalT+ " FROM" + " "
            +fDepart+ " " + "INNER JOIN" + " " +sBusSchedule+ " " +
            "ON " +sBusSchedule+ "." +sBusDate+ "=" +fDepart+ "." 
            +fDate+ " " + "WHERE " +fDate+ "= '" +fDate1+"'"+" "+
            "AND" + " " +sBusDepartT+ " " + "= strftime('%H:%M', '" +fTime+ "', '-" +mMinutes+" minute');");
      cur = fetchAllTodos()
        if(cur.getCount()==0){
            mustContinue = true ;
            switch(mMinutes){
            case 145 :
                mMinutes = 150 ;
                break;
            case 150 :
                mMinutes = 155 ;
                break;
            case 200 : //for max value for example
                mustContinue = false ;
                break;
                //etc ....
            }

        }else{
            mustContinue = false ;
        }
    }
    if(cur != null && cur.getCount()>0){
        cur.moveToFirst();
        Toast.makeText(getBaseContext(), cur.getString(0)+ "  " +cur.getString(1)+ "  "
                 +cur.getString(2)+ "  " +cur.getString(3)+ "\n",
                    Toast.LENGTH_LONG).show();
    }else{
        mMinutes = 145;
        Toast.makeText(this, "Not found", Toast.LENGTH_LONG).show();
    }
}