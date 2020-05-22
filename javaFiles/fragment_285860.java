/**
     * Static factory method to create a Criteria using the provided key
     * 
     * @param key
     * @return
     */
    public static Criteria where(String key) {
        return new Criteria(key);
    }

    /**
     * Static factory method to create a Criteria using the provided key
     * 
     * @return
     */
    public Criteria and(String key) {
        return new Criteria(this.criteriaChain, key);
    }