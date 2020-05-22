FacetOperation fo1 = facet(
        unwind("producer.fundings"),
        project().and("producer.fundings.type").as("type").and("producer.fundings.acronym").as("name"),
        group("name", "type").count().as("count"),
        project("count").and("_id.name").as("name").and("_id.type").as("type").andExclude("_id")
).as("fundingAcronymFacet")
        .and(unwind("producer.fundings"),
                project().and("producer.fundings.type").as("type").and("producer.fundings.acronym").as("name"),
                group("name", "type").count().as("count"),
                project("count").and("_id.name").as("name").and("_id.type").as("type").andExclude("_id")
        ).as("fundingNamesFacet");