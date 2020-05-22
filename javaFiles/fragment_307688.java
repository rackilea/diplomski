if someVar == null then
{
    callableStmnt = conn.prepareCall("{?=call myFunc()}");
    callableStmnt.registerOutParameter(1, OracleTypes.CURSOR); 
}
else
{
    callableStmnt = conn.prepareCall("{?=call myFunc(?)}");
    callableStmnt.registerOutParameter(1, OracleTypes.CURSOR); 
    callableStmnt.setString(2, someVar);
}
callableStmnt.execute;