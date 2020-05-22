public Long insertRows(String projectId, String datasetId, String tableId, File schema, File data) {
    try {
        return insertRows(projectId, datasetId, tableId, new FileInputStream(schema),
                new FileContent(MediaType.OCTET_STREAM.toString(), data));
    }
    catch (FileNotFoundException e) { throw Throwables.propagate(e); }
}