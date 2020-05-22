String insertString = "insert into workouts....."
Update pUpdate = handle.createStatement(insertString);

for(int i=0; i<vals.length;i++) {
        pUpdate.bind(i, vals[i]);
}

if (values.length < 32) {
    for(int i =(32 - values.length); i<32;i++) {
        pUpdate.bindNull(i, java.sql.Types.INTEGER);
    }
}

pUpdate.execute();