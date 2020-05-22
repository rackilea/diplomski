@Test
public void readTest() {
    // ormlite api init
    RuntimeExceptionDao<Object, Integer> dao = mock(RuntimeExceptionDao.class);
    ObjectDbHelper dbHelper = new ObjectDbHelper(context, dao);
    ObjectDataSource dataSource = new ObjectDataSource(context, dbHelper);

    // data init
    Object object = new Object() {{ setId(47); }};
    Object completeObject = new Object {{ setId(47); setObjectName("test object"); }}
    List<Object> list = ArrayList<Object>();
    list.add(completeObject);

    // testing
    dataSource.create(list);
    dataSource.delete(object);

    // verify that ObjectDataSource class correctly invokes delete
    // method on DAO:
    verify(dao).delete(object);
}