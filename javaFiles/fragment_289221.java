public ArrayList<Goal> readAllGoals(){
        ArrayList<Goal> goalReturnList = new ArrayList<Goal>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_GOALS; // Query to select all from goals table
        Cursor cursor = db.rawQuery(selectQuery, null);
        int counter = 0;
        int noFalse = 0;
        boolean z = true;

        while(z) { //the loop will check if there is a record or not and skip past blank records
            if(cursor.moveToPosition(counter)&&noFalse<25){ //if it can get to the next position and there has not been 25 missing in a row
                noFalse = 0; //Reset the counter for number of missing in a row
                Goal goal = new Goal(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                            cursor.getInt(3), cursor.getInt(4),
                            cursor.getInt(5), Boolean.parseBoolean(cursor.getString(7)), cursor.getString(6)); //Create the goal to add
                goalReturnList.add(goal); //Add it to the list 
            }else if(noFalse>=25){ 
                z = false;
            }else{
                noFalse++; //Add to the number of false in a row
            }
            counter++; //Increment the counter
        } 
        cursor.close();
        db.close();
        for (Goal g: goalReturnList){
            if (g.strokeGoal.equals("")) { //strip blank goals
                goalReturnList.remove(g);
            }
        }
        return goalReturnList;
    }