public List<FinancialMessageKey> findFinancialMessageKeys(FinancialMessageQueryDTO financialMessageQueryDTO) {

        Criteria filterCriteria = Criteria.where(CREATED_DATE)
            .gte(startDate)
            .lt(endDate);
        Sort sort = new Sort(Sort.Direction.DESC, "consolidatedBatchId", "version");

        Aggregation agg = Aggregation.newAggregation(
            Aggregation.match(filterCriteria),
            Aggregation.group(CONSOLIDATED_BATCH_ID, VERSION)
                .addToSet(new BasicDBObject() {
                              {
                                  put(CREATED_DATE, "$" + CREATED_DATE);
                                  put(SENDER, "$" + SENDER);
                                  put(RECEIVER, "$" + RECEIVER);
                                  put(MESSAGE, "$" + MESSAGE);
                              }
                          }
                ).as("messages"),
            Aggregation.sort(sort));

        AggregationResults<FinancialMessageKey> aggregationResults =
            mongoTemplate.aggregate(agg, FinancialMessage.class, FinancialMessageKey.class);

        return aggregationResults.getMappedResults();
    }