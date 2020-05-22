// Define the viewer
viewer = new ListViewer(parent);
viewer.setContentProvider(new ObservableListContentProvider());
List<Person> persons = new ArrayList<Person>();
// Just for testing we create sample data
createExampleData(persons);
input = new WritableList(persons, Person.class);
// Set the writeableList as input for the viewer
viewer.setInput(input);