Connection conn = null;
PreparedStatement pstm = null;
try {
    conn = ConnectionManager.getConnection();
    pstm = conn.CreateStatement(statement);
    //set statement
    }catch (SqlException ex) {
        throw new MyException("error");
    }catch (ClassNotFoundException ex) {
   
        throw new MyException("error");
     }finally {
        if(conn != null) {
         try {
            pstm.close();
            conn.close();
         } catch (SQLException e) {  
           // throw or log the exception;
         }

        }
    }
}