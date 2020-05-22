static class Duomenys{

        SQLiteDatabase sql;

        //Here i don't know how to assign my SQLiteOpenHelper,
        // so actually, I NEED HELP HERE
        ActivitiesDataBase db;
        public Duomenys(Context context){
            this.db = new ActivitiesDataBase(context);
        }

    }