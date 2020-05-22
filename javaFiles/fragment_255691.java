public String totalDenunciasEstadisticas() {
    ProjectionOperation proj = project().and("estadosDenuncia").arrayElementAt(-1).as("last");
    GroupOperation contar = Aggregation.group("last.estado").count().as("cantidad");

    Aggregation aggregate = Aggregation.newAggregation(proj, contar);

    AggregationResults<Denuncia> orderAggregate = mongoTemplate.aggregate(aggregate,
            "denuncia", Denuncia.class);

    return orderAggregate.getRawResults().toJson();
}