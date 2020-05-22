@Override
    protected void doGet (
            final HttpServletRequest request,
            final HttpServletResponse response
        ) throws
            ServletException,
            IOException
    {
        // some request preprocessing
        MyProcessedRequest parsedInputFromRequest =
            getInputFromRequest( request );

        final MyModel model;
        {
           // Model generation
           Connection conn = myGetConnection( );

           try
           {
              model = new MyModel( conn, parsedInputFromRequest );
           }
           finally
           {
              conn.close( );
           }
        }


        generateResponse( response, model );         
    }