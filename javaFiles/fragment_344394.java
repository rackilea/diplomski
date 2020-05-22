@JsonCreator
    public InsuredAmountA(
            @JsonProperty("type") String type,
            @JsonProperty("someInfo") String someInfo) throws IOException {
        switch (getProduct()) {
            case PROD_A:
                try {
                    this.type = IATypeA.valueOf(type);
                    break;
                } catch (IllegalArgumentException ex) {
                    // Throw IOException in the default.
                }
//            case PROD_B:
//                this.type = (IATypeB) typeA;
//                break;
            default:
                throw new IOException(String.format("Cannot parse value %s as type.", type));
        }
        this.someInfo = someInfo;
    }