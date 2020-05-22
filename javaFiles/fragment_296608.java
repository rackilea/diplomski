Employee employee = new Employee();
String name = "Ronnie";
entityManager.getTransaction.begin();
employee.setName(name);
entityManager.persist(employee);
entityManager.flush();

//After few steps, the transaction is still the same
entityManager.remove(employee);
entityManager.getTransaction.commit();