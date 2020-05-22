final Scanner in = new Scanner(new FileReader("filename.txt"));
    final List<Person> persons= new ArrayList<Person>();
    while (in.hasNext()) {
        final String[] columns = in.next().split(" ");
                    final Person person = new Person();
                    Person.setId(column[0]);
                    Person.setName(column[1]);
                    // like this you can set all the fields     
        persons.add(person);
    }