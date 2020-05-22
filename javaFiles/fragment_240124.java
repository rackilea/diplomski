@Getter
@Builder(builderClassName = "Builder", buildMethodName = "build")
public final class BusinessEvent {
    private String action, duration, outcome, provider, trackId, sequence;
    private Optional<String> brand, vin, externalTrackId, code = Optional.empty();
    private Optional<Object> eventError = Optional.empty();

    static class Builder {
        BusinessEvent build() {
            if (brand == null) {
                throw new RuntimeException("brand not set");
            }
            // Custom validation
            return new BusinessEvent(action, duration, outcome, provider, trackId, sequence, brand, vin, externalTrackId, code, eventError);
        }
    }

    public static void main(String[] args) {
        BusinessEvent eventWithBrand = BusinessEvent.builder().brand(Optional.of("brand")).build();
        // will throw exception
        BusinessEvent event = BusinessEvent.builder().build();
    }
}