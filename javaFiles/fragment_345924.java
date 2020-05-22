public class ChannelLogicHandler extends ChannelInboundHandlerAdapter
{
private java.sql.Connection dbConnection = null; //DB connection saved as private member of logic handler
//........................

@Override
public void channelActive(ChannelHandlerContext ctx) throws Exception
{
    EventExecutor ex = ctx.executor(); //Get channel executor
    synchronized(execConsMap)
    {
    if (execConsMap.containsKey(ex)) //If already processed get DB connection from hashmap
    {
        dbConnection = execConsMap.get(ex);
    }
    else //Else create new connection and save in hashmap
    {
        java.sql.Connection dbc = DriverManager.getConnection(dbConnectParams[0], dbConnectParams[1], dbConnectParams[2]);
        if (dbc != null)
        {
        execConsMap.put(ex, dbc);
        dbConnection = dbc;
        }
        else
        {
        throw new SQLException("Connection to database failed");
        }
    }
    }

    System.out.println("New client connected");
    super.channelActive(ctx);
}

@Override
public void channelInactive(ChannelHandlerContext ctx) throws Exception
{
    try
    {
    if (!dbConnection.getAutoCommit())
    {
        dbConnection.rollback();
        dbConnection.setAutoCommit(true);
    }
    }
    catch (SQLException e) 
    { 
    e.printStackTrace(); 
    }

    System.out.println("Client disconnected");
    super.channelInactive(ctx);
}