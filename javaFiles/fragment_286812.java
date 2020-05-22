for (String record : records) {
    System.out.println(record);

    String[] elements = record.split("\\|");
    for (String element : elements) {
        System.out.println(" -> " + element);
    }
}