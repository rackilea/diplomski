Query q = pm.newQuery("select from Person " +
                      "where lastName == lastNameParam " +
                      "parameters String lastNameParam " +
                      "order by height desc");

List<Person> results = (List<Person>) q.execute("Smith");