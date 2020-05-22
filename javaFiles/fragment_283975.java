Statement stmt = null;
String[] sqlx = {
    "insert into abc(col1,col2) values('first', 'data')",
    "insert into abc(col1,col2) values('second','data')",
    "insert into abc(col1,col2) values('third', 'data')"
};
for(String sqIn : sqlx){
    stmt.addBatch(sqIn);
}
int[] chkSql = stmt.executeBatch();