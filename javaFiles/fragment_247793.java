BigDecimal[] totalWithCount
                = bigDecimals.stream()
                .filter(bd -> bd != null)
                .map(bd -> new BigDecimal[]{bd, BigDecimal.ONE})
                .reduce((a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(BigDecimal.ONE)})
                .get();
BigDecimal mean = totalWithCount[0].divide(totalWithCount[1], roundingMode);