public static List<Map<TypeId, Object>> merge(
        List<Map<TypeId, Object>> col1,
        Map<PlatformAndPlayer, BigDecimal> col2) {
    for (Map<TypeId, Object> map : col1) {
        map.put(TypeId.AMOUNT, col2.get(new PlatformAndPlayer(
            (int) map.get(TypeId.PLAYER), (int) map.get(TypeId.PLATFORM))));
    }
    return col1;
}