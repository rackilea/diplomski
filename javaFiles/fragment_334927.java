double[][] mat =
    listReturns.stream() // Stream<List<Double>>
               .map(list -> list.stream() 
                                .mapToDouble(Double::doubleValue)
                                .toArray()) // map each inner List<Double> to a double[]
               .toArray(double[][]::new); // convert Stream<double[]> to a double[][]