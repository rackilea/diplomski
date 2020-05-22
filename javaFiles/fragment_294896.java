query.setParameter(Entry.NAME, myEntry.getName());

...

if(!StringUtils.equals(result.getName(), myEntry.getName()){
   do a cool throw just like NoResultException Catch
}