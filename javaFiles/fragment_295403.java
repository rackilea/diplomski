public static final char CSV_SEPARATOR = ';'; // it could be a comma or a semi colon

try (BufferedWriter writer = new BufferedWriter(new FileWriter("my_file.csv"))) {
    personList.forEach(person -> {
        writer.append(person.getName()).append(CSV_SEPARATOR)
              .append(person.getAge()).append(CSV_SEPARATOR)
              .append(persone.getAddress().getStreet()).append(CSV_SEPARATOR)
              .append(persone.getAddress().getpostCode()).append(CSV_SEPARATOR)
              .append(persone.getAddress().getCity()).append(CSV_SEPARATOR)
              .append(persone.getAddress().getCountry()).append(System.lineSeparator());
    });
} catch (IOException ex) {
    ex.printStackTrace();
}