// Creating some dummy data
List<String> userList = Arrays.asList("Test: XX    Genere: Maschio    Eta: YY    Protocollo: A    Date:28/08/2019",
        "Test: XX    Genere: Maschio    Eta: YY    Protocollo: A    Date:26/08/2019",
        "Test: XX    Genere: Maschio    Eta: YY    Protocollo: A    Date:30/08/2019",
        "Test: XX    Genere: Maschio    Eta: YY    Protocollo: A    Date:12/08/2019");

// Sorting based on LocalDate
userList.sort(Comparator.comparing(s -> {
    String stringDate = s.substring(s.lastIndexOf(':') + 1).trim();
    return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
}));

// printing the lists
userList.forEach(System.out::println);