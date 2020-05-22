logicExecutor.shutdownGracefully().addListener(new GenericFutureListener()
     {
        @Override
        public void operationComplete(Future future) throws Exception
        {
            for (java.sql.Connection conn : execConsMap.values())
            {
                try 
                {
                    if (!conn.getAutoCommit())
                    conn.rollback();
                } catch (SQLException e) 
                { e.printStackTrace(); }

                try 
                {
                    conn.close();
                } catch (SQLException e) 
                { e.printStackTrace(); }
            }
        }
     });