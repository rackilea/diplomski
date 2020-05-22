private static boolean isGoodEnought(Deque<InfoWrapper> list, int max) {
    Set<String> seenNames = new HashSet<>();
    for (Iterator<InfoWrapper> i = list.iterator(); i.hasNext() && max-- > 0;)
        if (!seenNames.add(i.next().getName()))
            return false;
    return true;
}