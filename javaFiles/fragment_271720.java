JavaRDD<Integer> numRDD = null;
if(rowsPerPartition > maxRowsPerPartition){
    numRDD = seqRDD.mapPartitions(new PartitionMapFunction(maxRowsPerPartition));               
    rowsPerPartition = rowsPerPartition/maxRowsPerPartition + 1;
    numRDD = numRDD.flatMap(new PartitionFlatMapFunction(rowsPerPartition, numHex));
} else {
    numRDD = hexIdRDD.mapPartitions(new PartitionMapFunction(rowsPerPartition));
}