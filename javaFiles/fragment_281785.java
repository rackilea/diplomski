class Person {

    public String firstName;
    public String lastName;
    public String address;
    public String address2;
    public String city;
    public String state;
    public String zip;
    public String phone;
    public String email;

    public Person(String firstName, String lastName, String address, String address2, String city, String state, String zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;

    }

    public String[] toStrings() {
        return new String[]{firstName, lastName, address, address2, city, state, zip, phone, email};
    }

    public static String[][] toStringsMatrix(ArrayList<Person> personList) {
        int rows = personList.size();
        String[] first = personList.get(0).toStrings();
        int columns = first.length;
        String[][] table = new String[rows][columns];
        table[0] = first;
        for (int k = 1; k < rows; k++) {
            table[k] = personList.get(k).toStrings();
        }
        return table;
    }
}