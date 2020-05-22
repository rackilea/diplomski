interface GeometryMixIn {

    @JsonIgnore
    Envelope getEnvelope();

    @JsonIgnore
    PositionSequence getPositions();
}