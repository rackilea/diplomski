/** Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
    public MatchQueryBuilder fuzziness(Object fuzziness) {
        this.fuzziness = Fuzziness.build(fuzziness);
        return this;
    }

    /**  Gets the fuzziness used when evaluated to a fuzzy query type. */
    public Fuzziness fuzziness() {
        return this.fuzziness;
    }