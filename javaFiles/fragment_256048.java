public void setParameter(ParameterSetter setter, Object parameter) throws SQLException
{
    ArrayDescriptor desc = ArrayDescriptor.createDescriptor("STRARRAY", setter.getPreparedStatement().getConnection());
    ARRAY oracleArray = new ARRAY(desc, setter.getPreparedStatement().getConnection(), parameter);
    setter.setArray(oracleArray);
}