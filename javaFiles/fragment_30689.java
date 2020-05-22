Predicate<Object> testAgencyIdAndDepotId = (v) -> userInfo.getAgencyId() != null && userInfo.getDepotId() != null;
Predicate<Object> testSearch = (v) -> !search.isEmpty();
Predicate<Object> testFromdate= (v) -> fromdate != null;
Predicate<Object> testStatus = (v) -> status.isPresent();

Map<Predicate<Object>, Supplier<Object>> mapIf = Map.of(
        testAgencyIdAndDepotId.and(testSearch).and(testFromdate).and(testStatus),
        () -> wayBillRepository.findWaybillOnDateAndStatusSearchAgencyAndDepotPageable(
                fromDate, toDate, status.get(), search, userInfo.getAgencyId(), userInfo.getDepotId(),
                page),
        testAgencyIdAndDepotId.and(testSearch).and(testFromdate).and(Predicate.not(testStatus)),
        () -> wayBillRepository.findWaybillOnDateAndStatusSearchAgencyAndDepotPageable(
                fromDate, toDate, search, userInfo.getAgencyId(), userInfo.getDepotId()
                page)
        // other conditions
);

allwaybillCollection = mapIf.entrySet().stream().filter(e -> e.getKey().test(null)).findFirst()
        .map(Map.Entry::getValue).map(Supplier::get).orElse(null);