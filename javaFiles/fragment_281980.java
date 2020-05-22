List<Customer> c2 = new ArrayList<Customer>(); //Or any other class implementing List
CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
String [] nextLine;
while ((nextLine = reader.readNext()) != null) {
    Customer c = new Customer(nextLine); //Or create a new Customer in some way
    c2.add(c);
}