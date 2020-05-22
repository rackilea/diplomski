public bulkDelete(final HTable table) throws IOException {
    Scan s=new Scan();
    List<Delete> listOfBatchDelete = new ArrayList<Delete>();
    //add your filters to the scanner
    s.addFilter();
    ResultScanner scanner=table.getScanner(s);
    for (Result rr : scanner) {
        Delete d=new Delete(rr.getRow());
        listOfBatchDelete.add(d);
    }
    try {
        table.delete(listOfBatchDelete);
    } catch (Exception e) {
        LOGGER.log(e);

    }
}