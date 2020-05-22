Map<String, List<String>> emailsByPrefix = new HashMap<>();

for (int i = 0; i < fList.size(); i++) {

    String subString = fList.get(i).split("-")[0];

    emailsByPrefix.merge(subString, Arrays.asList(fList.get(i)), (list1, list2) -> {
        List<String> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);

        return merged;
    });
}

for (Entry<String, List<String>> emailEntry : emailsByPrefix.entrySet()) {
    System.out.println("Sending e-mail for prefix " + emailEntry.getKey());
    createEmail(emailEntry.getValue());
}