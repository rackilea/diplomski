//Skeleton to handle exception and log in one place 
public void doBusiness(CallBack callBack)  throws SqlException{
    try{
        callBack.invoke();
    }catch(SqlExceptione){
        logger.log (e);
        throws e;
    }
}