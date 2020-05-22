String[] lineData = readLineData();
Person onePerson = new Person();
FileDataUtilities util = new FileDataUtilities();
try {
    util.build(onePerson, lineData);
    util.validate(onePerson);
} catch (InvalidDataException e) {
    // What to do it its bad?
}