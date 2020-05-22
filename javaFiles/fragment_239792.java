public static House read(Scanner sc) throws IOException {
    sc.next(); //load house informations, i don't know how your file looks like

    Scanner addressSc = new Scanner(new File(/* address file path */));
    Address address = Address.read(addressSc);

    House house = new House(address, /* other parameters */);
}