String selectQuery = "SELECT " + KEY_LABEL_ID + ", " + " SUM(" + KEY_AMOUNT + ") as total, " + KEY_TYPE_ID + " " +
                         "FROM (" +
                                    "SELECT " + KEY_LABEL_ID + ", " + KEY_AMOUNT  + ", " + KEY_TYPE_ID + " " +
                                    "FROM " + TABLE_TRANSACTIONS + " " +
                                ") as trans_table " +
                         "WHERE " + KEY_TYPE_ID + " = " + TagData.TYPE_EXPENSE + "  " + 
                         "GROUP BY " + KEY_LABEL_ID + " " +                     
                         "ORDER BY total DESC";