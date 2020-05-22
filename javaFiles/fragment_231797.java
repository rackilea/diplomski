public interface BaseObjectMixIn {
        @JsonIgnore
        String getId();

        ... rest of annotations for superclass
    }