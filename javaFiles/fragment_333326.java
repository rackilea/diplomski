String[] lineData = readLineData();
FileDataValidator onePerson = new FileDataValidator();
try {
    onePerson.build(lineData);
} catch (InvalidDataException e) {
    // What to do it its bad?
}