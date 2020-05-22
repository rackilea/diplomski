SimpleQuery groupQuery = new SimpleQuery(conditions);

GroupOptions groupOptions = new GroupOptions()
        .addGroupByField(groupByField);

groupQuery.setGroupOptions(groupOptions);

return solrTemplate.queryForGroupPage(groupQuery, YourObjectHere.class);