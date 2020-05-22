private static boolean isGoodEnought(Deque<InfoWrapper> list,
                                     int maxFailsCount) {
    return list.stream()
               .limit(maxFailsCount)
               .map(InfoWrapper::getName)
               .distinct()
               .count() == maxFailsCount;
}