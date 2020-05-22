List<UserDb> listA = ...;
List<UserLdap> listB = ...;

Map<String, UserDb> a = listA.stream().collect(toMap(UserDb::getUserId, Function.identity());
Map<String, UserDb> b = listB.stream().collect(toMap(UserLdap::getUserId, Function.identity());

Set<String> allIds = new HashSet<>();
allIds.addAll(a.keySet());
allIds.addAll(b.keySet()); // Or retainAll if you want the intersection instead of the union

List<FinalType> = allIds.stream().map(id -> {
    UserDb userDb = a.get(id);
    UserLdap userLdap = b.get(id);
    FinalType t = // Build this one from the 2 others. Be careful that either can be null
    return t;
}).collect(toList());