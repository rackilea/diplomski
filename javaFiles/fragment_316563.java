ICombinatoricsVector<BigDecimal> originalVector = 
            Factory.createVector(new BigDecimal[] { 
                    new BigDecimal("0.0"), 
                    new BigDecimal("0.1"), 
                    new BigDecimal("0.2"), 
                    new BigDecimal("0.3"), 
                    new BigDecimal("0.4"), 
                    new BigDecimal("0.5"), 
                    new BigDecimal("0.6"), 
                    new BigDecimal("0.7"), 
                    new BigDecimal("0.8"), 
                    new BigDecimal("0.9")
    });

    Generator<BigDecimal> gen = Factory.createPermutationWithRepetitionGenerator(originalVector, 3);

    for (ICombinatoricsVector<BigDecimal> perm : gen) {
        // values are in perm.getValue(0), perm.getValue(1), and perm.getValue(2)
    }