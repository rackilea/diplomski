//Service
@Override
@Transactional
public long saveAndCount(List<Foo> listOfFoo){
    for(Foo foo : listOfFoo){
        //Doesn't get instantly saved to the database.
        fooDAO.saveOrUpdate(foo);
    }
    /*
     * Before the actual SELECT COUNT(*) query was run, the SessionFactory would
     * flush the save operation of the 5 Foo objects.
     */
    return fooDAO.count();
}