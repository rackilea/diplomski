B dbB = (B) unmarshaller.getDetachedSession().createCriteria(B.class).add(Restrictions.idEq(aInstance.getId())).uniqueResult();

if (dbB != null) //exists in DB
{
    aInstance.getB().setId(aInstance.getId()); //Tell hibernate it is an Update
    //Do the same for any other child classes to B with the same strategy if there are any in here
}
else
{
    aInstance.getB().setId(null); //Tell hibernate it is a Save
}

unmarshaller.getDetachedSession().clear();