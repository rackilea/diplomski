public class OwnHealthAggregator implements HealthAggregator {

private final HealthAggregator defaultHealth;

public OwnHealthAggregator(HealthAggregator defaultHealth) {
    this.defaultHealth = defaultHealth;
}

@Override
public Health aggregate(Map<String, Health> healths) {
    Health result = this.defaultHealth.aggregate(healths);
    // LOG Result here
    return result;
}

}