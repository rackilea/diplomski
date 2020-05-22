List<Document> pipeline = Arrays.<Document>asList(
    new Document("$project",
        new Document("TOTAL_EMPLOYEE_SALARY",new Document("$sum","$employees.EMP_SALARY"))
    )
);

AggregationOutput output = coll.aggregate(pipeline);