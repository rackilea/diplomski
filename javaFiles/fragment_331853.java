package com.mypackage.dao;
@Repository
@Qualifier("myDAOBasePackage")
public class MyDao
{
// some code here
}



   package com.mypackage.one.dao;

    @Repository
    @Qualifier("myDAOSubPackage")
    public class MyDao {
    // some other code here
    }