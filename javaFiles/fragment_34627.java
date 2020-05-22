public static void copyColumns(String copyFrom, String copyTo, String outputFile, String idCol, String[] copyCols) {
    Dataset<Row> from =  readCSV(copyFrom);
    Dataset<Row> to = readCSV(copyTo);

    for(String copyCol : copyCols) {
        to = to.join(
                from.select(idCol, copyCol),
                to.col(idCol).equalTo(from.col(idCol)),
                "left_outer"
            )
            .withColumn("NewCol",
                when(from.col(copyCol).isNotNull, from.col(copyCol))
                    .otherwise(to.col(copyCol))
            .drop(from.col(idCol))
            .drop(from.col(copyCol))
            .drop(to.col(copyCol))
            .withColumnRenamed("NewCol", copyCol);
    }

    writeCSV(to, outputFile);
}