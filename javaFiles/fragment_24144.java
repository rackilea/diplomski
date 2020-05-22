ResultSet res = sta.executeQuery(
            "SELECT * FROM TOBEDELETED for update "); 
          while (res.next()) {
             myblob = res.getBlob("IMG");

          }       
    callablestatement = 
            conn.prepareCall("{CALL my_proc(?,?)}");
    callablestatement.setInt(1, 100);        
            if(myblob==null){            
        callablestatement.setNull(2,java.sql.Types.BLOB); 

    }
    else {
        byte[] chuck = {(byte)0x00, (byte)0x00, (byte)0x00,
                  (byte)0x00, (byte)0x00, (byte)0x00};
                myblob.setBytes(1,chuck);
    callablestatement.setBlob(2,myblob); 
    }
    int affectedRows = callablestatement.executeUpdate();