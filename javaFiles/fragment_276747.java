public class DAOSuite{
    Class[] testClasses = {
        UserDAOTest.class,
        BooksDAOTest.class,
        BorrowsDAOTest.class
    };
    TestSuite = new TestSuite(testClasses);
}