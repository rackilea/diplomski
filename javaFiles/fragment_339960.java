db.setAutoCommit(false);
stm = db.prepareStatement("INSERT INTO YOURTABLE (NUMBER1,NUMBER2 ,NUMBER3, NUMBER4, NUMBER5) VALUES (?, ?, ?, ?, ?)");
for (int i = 0; i < 5; i ++){ // rows 
        stm.setString(1, multiarray[i][0]);  
        stm.setString(2, multiarray[i][1]); 
        stm.setString(3, multiarray[i][2]); 
        stm.setString(4, multiarray[i][3]); 
        stm.setString(5, multiarray[i][4]);      
        stm.addBatch();
}
stm.executeBatch();
db.commit();