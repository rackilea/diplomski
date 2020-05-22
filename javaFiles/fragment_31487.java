connection.setAutoCommit(false);

int arrayVals = Math.min(arrayColId.length, arrayQId.length);
for (int i = 0; i < arrayVals; i++) {
    ps.setString(1, arrayColId[i]);
    ps.setString(2, arrayQId[i]);
    ps.addBatch(); //add a batch
}

ps.executeBatch();//execute your batch

connection.commit();//when you finish you should to commit your transaction