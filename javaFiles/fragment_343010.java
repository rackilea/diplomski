Map<String, List<String>> distinctMap = fList.stream()
            .collect(Collectors.groupingBy(s -> s.split("-")[0]));

distinctMap.forEach((str1, list) -> {
    System.out.println("Sending e-mail for prefix " + str1);
    createEmail(list);
});