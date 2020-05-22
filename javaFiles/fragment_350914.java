/**
     * Construct the normalization utility, allow the normalization range to be specified.
     * @param dataHigh The high value for the input data.
     * @param dataLow The low value for the input data.
     * @param dataHigh The high value for the normalized data.
     * @param dataLow The low value for the normalized data. 
     */
    public NormUtil(double dataHigh, double dataLow, double normalizedHigh, double normalizedLow) {
        this.dataHigh = dataHigh;
        this.dataLow = dataLow;
        this.normalizedHigh = normalizedHigh;
        this.normalizedLow = normalizedLow;