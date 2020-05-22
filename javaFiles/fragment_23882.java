interface EmployeeDatabase {
   interface StringWhereClause {
     ListQueryBuilder is(String value);
     ListQueryBuilder contains(String value);
     ListQueryBUilder matchesRegex(String regex);
   }

   interface IntWhereClause {
     ListQueryBuilder is(int value);
     ListQueryBuilder isInRange(int min, int max);
     ListQueryBuilder isGreaterThan(int value);
     ListQueryBUilder isLessThan(int value);
     ListQueryBuilder isGreaterThanOrEqualTo(int value);
     ListQueryBUilder isLessThanOrEqualTo(int value);
   }
   // ... matchers for other types of properties ...

   interface ListQueryBuilder {
      // Generic restrict methods
      StringWhereClause whereStringProperty(String propertyName);
      IntWhereClause whereIntProperty(String propertyName);
      // ...

      // Named restrict methods
      StringWhereClause whereName();
      StringWhereClause whereJobTitle();
      IntWhereClause whereEmployeeNumber();
      // ...

      ListQueryBuilder limit(long maximumSize);
      ListQueryBuilder offset(long index);

      ResultSet<Employee> fetch();
   }

   ListQueryBuilder list();
   ListenableFuture<Employee> getById(Key key);
   ListenableFuture<KeyOrError> add(Employee employee);
   ListenableFuture<Status> update(Key key, Employee employee);
   ListenableFuture<Status> delete(Key key);
}