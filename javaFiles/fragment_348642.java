String sql = "INSERT OR REPLACE INTO registro_status (bit, value) VALUES ";
int    bit = 1;

for (String value: valuearray) {
    sql = sql+ "("+ bit +", " +value +"),";
}

// cut last comma and add semi colon
sql = sql.substring (0, sql.length() -1) +";";

db.execSQL(sql);