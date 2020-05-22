@Autowired
private SearchRestrictionService searchRestrictionService;

private BigDecimal findGroupedOrdersData(String total, String uncDisc, String orderPromo,
    Map<String, Object> queryParameters) {

  searchRestrictionService.disableSearchRestrictions();

  // You code here

  searchRestrictionService.enableSearchRestrictions();
  return aggregatedValue;
}