static abstract class GeoResultsMixin {
    GeoResultsMixin(@JsonProperty("results") List<GeoResult> results, 
                    @JsonProperty("averageDistance") Distance averageDistance) {
    }

    @JsonProperty("results")
    abstract List<GeoResult> getContent(); 
}