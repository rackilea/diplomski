String[] values = strLine.split(";");
List<String> list = Arrays.asList(values);

if (Collections.frequency(list, list.get(0) > 1) {
    System.out.println("The first value is not unique in the list");
}