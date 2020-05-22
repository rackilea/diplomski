public static List<UserRole> removeDupesBySetTheory(final List<UserRole> originalList)
{
    final Set<UserRole> holdingSet = new HashSet<>();

    holdingSet.addAll(originalList);

    final List<UserRole> newList = new ArrayList<>();

    newList.addAll(holdingSet);

    return newList;
}