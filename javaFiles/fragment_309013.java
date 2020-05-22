try {

    Context initialContext = new InitialContext();
    DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
    Connection con = datasource.getConnection();
    }catch(Exception e) {}