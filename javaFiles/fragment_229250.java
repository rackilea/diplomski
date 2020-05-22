int i = GetAllData.getCount();

        ArrayList<DB_Get_Values> dbList = new ArrayList<DB_Get_Values>();

        while (GetAllData.moveToNext()) {
            DB_Get_Values w = new DB_Get_Values(GetAllData.getString(0), GetAllData.getString(1), GetAllData.getString(2));
            dbList.add( w );
            j++;
        }