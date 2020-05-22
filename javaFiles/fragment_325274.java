transactionManager.begin()
 doSomeJdbcStuff();
 Transaction main = transactionManager.suspend();

 // do the logging
 transactionManager.begin()  // <- now a new transaction is created and active!
 doSomeLogging();
 transactionManager.commit()

 // continue
 transactionManager.resume(main);
 doSomeMoreJdbcStuff();
 transactionManager.commit();