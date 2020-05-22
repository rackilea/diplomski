String sqlDataStore = "create table if not exists " +
        TABLE_NAME_INFOTABLE + " ("+ BaseColumns._ID + " integer primary key autoincrement,"
                + COLUMN_NAME_SITE + "text not null,"
                + COLUMN_NAME_ADDRESS + "text not null,"
                + COLUMN_NAME_USERNAME + "text not null,"
                + COLUMN_NAME_PASSWORD + "text not null)";