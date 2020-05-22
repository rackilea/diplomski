private BaseObject getModel(){

    Application pd = this.getApplicationHook();

    model = pd.OpenModel(this.basePath + this.modelName);
    System.out.println( "Retrieving model updates from repository...  ");

    RepositoryConnection conn = new RepositoryConnection( pd.GetRepositoryConnection() );
    conn.Open( "", "", ConnectionParams.PASSWORD);

    boolean success = new BaseModel(model).UpdateFromRepository();

    if( success )
        System.out.println( "Update successful!" );
    else
        System.out.println( "Update failed. Check PowerDesigner settings." );

    return this.model;
}