String query = "select count(*) from " + B.class.getName() + " where id = " + aInstance.getId();
Long count = DataAccessUtils.uniqueResult(hibernateTemplate.find(query));

if (count != null && count > 0)
{
    aInstance.getB().setId(aInstance.getId()); // update
}
else
{
    aInstance.getB().setId(null); // save
}