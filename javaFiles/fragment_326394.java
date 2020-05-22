TypedAggregation<Applicate> aggregation = newAggregation(Applicate.class,
            match(Criteria.where("claimantCategory").is(claimantCategory)),
            project("claimDate")
                    .andExpression("dayOfMonth(claimDate)").as("day")
                    .andExpression("month(claimDate)").as("month")
                    .andExpression("year(claimDate)").as("year"),
            group(fields().and("day").and("month").and("year")).first("claimDate").as("claimDate")
                    .count().as("count"));