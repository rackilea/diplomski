import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

TypedAggregation<Entity> aggregation = newAggregation(Entity.class,
    sort(DESC, "snapshot"),
    group("id")
        .first("snapshot").as("snapshot")
        .first("name").as("name")
);

AggregationResults<EntityStats> result = mongoTemplate.aggregate(aggregation, EntityStats.class);