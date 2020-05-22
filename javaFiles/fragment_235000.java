for (int i = 0; i < averages.getRowDimension(); i++) {
     double average = 0;
     for (BlockRealMatrix aMatrixHolder : matrixHolder)
           average += Arrays.stream(aMatrixHolder.getRow(i)).sum();
     average /= (matrixHolder.size() * matrixHolder.get(0).getColumnDimension());
     averages.setEntry(i, 0, average);
}