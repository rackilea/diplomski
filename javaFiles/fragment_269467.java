String queryString = "select u from User u left join u.addresses "+
                     "where u.username = :userName and u.password = :password";
Query query = session.createQuery(queryString );
query.setParameter("userName", userNameValue);
query.setParameter("password", passwordValue);
List<User> users = query.list();