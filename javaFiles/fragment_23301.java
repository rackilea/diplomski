@Override
    protected void doGet (
            final HttpServletRequest request,
            final HttpServletResponse response
        ) throws
            ServletException,
            IOException
    {
        Connection conn = myGetConnection( );

        try
        {
            ...
            // some request handling


        }
        finally
        {
            conn.close( )
        }
    }