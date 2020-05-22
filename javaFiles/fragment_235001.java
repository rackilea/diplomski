IntStream.range(0, averages.getRowDimension())
         .forEach(i -> {
             double average = matrixHolder.stream()
                                          .mapToDouble(m -> Arrays.stream(m.getRow(i)).sum())
                                          .sum();
             average /= (matrixHolder.size() * matrixHolder.get(0).getColumnDimension());
             averages.setEntry(i, 0, average);
         });