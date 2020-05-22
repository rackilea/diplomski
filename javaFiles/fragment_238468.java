Set<ObjectId> idSet = Arrays.stream(accountOid)             // Stream over String[]
                            .map(str -> new ObjectId(str))  // Create ObjectId from each
                            .collect(Collectors.toSet());   // Collect to Set<ObjectId>

List<AccountHoldCompositeObj> list = Arrays
    .stream(accts)                                          // Stream over AccountHoldCompositeObj[]
    .filter(acct -> idSet.contains(acct.getAccountOid()))   // Filter elements by IDs
    .collect(Collectors.toList());                          // Collect to List