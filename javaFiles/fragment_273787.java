MyDataAccessObject mdao = new MyDataAccessObject(connectionString, username, password);
mdao.init(); // now you're ready

List<Person> list = mdao.getAllPersons();
// do stuff with your list

....
mdao.addPerson(someNewPerson);
// ....

// now you're done running, so close it down
mdao.shutdown();