Scan scan = new Scan();
scan.addColumn(HbaseJsonEventSerializer.COLUMFAMILY_FILTERS_BYTES,
                Bytes.toBytes(columnName));
        Filter filter = new SingleColumnValueFilter(HbaseJsonEventSerializer.COLUMFAMILY_FILTERS_BYTES,
                Bytes.toBytes(columnName), CompareOp.EQUAL, Bytes.toBytes(columnValue));
        scan.setFilter(filter);

        List<String> rows  =
        hbaseTemplate.find("searchclicks", scan, new RowMapper<String>() {
            @Override
            public String mapRow(Result result, int rowNum) throws Exception {
                byte[] value = result.getValue(
                        HbaseJsonEventSerializer.COLUMFAMILY_FILTERS_BYTES,
                        Bytes.toBytes(columnName));
                if (value != null) {
                    String facetValue = new String(value);
                    LOG.debug("Facet field: {} and Facet Value: {}",
                            new Object[] { columnName, facetValue });
                }
                return facetValue;
            }
        });