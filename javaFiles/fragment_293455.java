public void header(List<DynaBean> headerColumns) throws WriteException {
    for (DynaBean column : headerColumns) {
        /*
         * RowSetDynaClass returns beans with lower case properties by default
         * but this is not guaranteed if beans are coming from Hibernate.
         * 
         * Converting from the bean to a map however loses DynaBeans' inherent
         * type conversions, which in turn entails the converting back and forth
         * from String, to BigDecimal, to int as seen below
         */
        Map columnMap = asLowerCaseIndexedMap(column);

        int col = (new BigDecimal(columnMap.get("columnnbr").toString())).intValue();
        int width = (new BigDecimal(columnMap.get("columnwdth").toString())).intValue();