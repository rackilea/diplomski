// Building the new sk (JSON ) objects
 List<NewSk> newSkList = new ArrayList<>();
 recordListBySK
    .values()
    .stream()
    .flatMap(v -> v.stream())
    .forEach(csvRecord -> {
         NewSk newSk = new NewSk(csvRecord.get("SK"),
                                csvRecord.get("VR"),
                                csvRecord.get("ST"),
                                skMaxMap.get(csvRecord.get("SK"))
                                );
         newSkList.add(newSk);
    });