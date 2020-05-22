List<String> destinations = new ArrayList<>();
System.out.println("Vnesite ime mesta kamor potujete: ");
    String mesto = scan.next();
    System.out.println("Vnesite ime države kamor potujete: ");
    String drzava = scan.next();
    destinations.add(drzava);
    System.out.println("Vnesite ime mesta iz katerega potujete: ");
    String mesto2 = scan.next();
    System.out.println("Vnesite ime države iz katere potujete: ");
    String drzava2 = scan.next();
    destinations.add(drzava2);

    Kraj kraj = new Kraj(mesto, destinations);