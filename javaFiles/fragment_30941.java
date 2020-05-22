Query privatePostableQuery = postableQB.bool()
            .should(postableQB.keyword().onField("visibility").matching(PostableVisibility.FOLLOWERS).createQuery())
            .should(postableQB.keyword().onField("visibility").matching(PostableVisibility.INVITE).createQuery())
            .createQuery();
String defaultTimeZone = "America/New_York";
LocalDate today = LocalDate.now(ZoneId.of(defaultTimeZone));
Query pastEventQuery = eventQB.range().onField("schedule.startDate").below(today).excludeLimit().createQuery();

// User text query
Query userQuery = postableQB.simpleQueryString().onField("name").boostedTo(5f) // working
        .andField("type").boostedTo(3f)
        .andField("description")
        .andField("username").boostedTo(5f)
        .matching(userQueryString)
        .createQuery();

Query combinedQuery = postableQB.bool()
        .must(userQuery)
        .must(privatePostableQuery).not()
        .must(pastEventQuery).not()
        .createQuery();