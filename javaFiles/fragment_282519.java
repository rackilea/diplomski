catch(DataAccessException e)
    {
            Throwable t = e.getCause();               
            SQLException ex = (SQLException) t.getCause();
            while(ex != null){
                 while(t != null) {
                     t = t.getCause();
                 }
                 logger.warn("SQLException="+ex.getLocalizedMessage());

                 ex = ex.getNextException();
            }
    }