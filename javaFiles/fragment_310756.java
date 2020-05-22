JavaPairRDD<String, Row> result = inputDataFrame.javaRDD().mapToPair(new  PairFunction<Row, String, Row>() {
    private static final long serialVersionUID = 1L;
    public Tuple2<String, Row> call(Row tblRow) throws Exception {
        String strID= CommonConstant.BLANKSTRING;
        Object[] newRow = new Object[schemaSize];
        for(String s: matchKey)
        {
            if(tblRow.apply(finalSchema.get(s))!=null){
                strID+= tblRow.apply(finalSchema.get(s)).toString().trim().toLowerCase();
            }                           
        }   
        int rowSize=    tblRow.length();
        for (int itr = 0; itr < rowSize; itr++)
        {
            if(tblRow.apply(itr)!=null)
            {
                newRow[itr] = tblRow.apply(itr);
            }
        }
        newRow[idIndex]= Utils.generateKey(strID);
        return new Tuple2<String, Row>(strID,RowFactory.create(newRow));
    }
}).aggregateByKey(RowFactory.create(arr), new Function2<Row,Row,Row>(){

    private static final long serialVersionUID = 1L;

    public Row call(Row argRow1, Row argRow2) throws Exception {
        // TODO Auto-generated method stub

        Integer rowThreshold=   dataSchemaHashMap.get(CommonConstant.STR_TEMPThreshold);
        Object[] newRow = new Object[schemaSize];
        int rowSize=    argRow1.length();

        for (int itr = 0; itr < rowSize; itr++)
        {
            if(argRow1!=null && argRow2!=null)
            {
                if(argRow1.apply(itr)!=null && argRow2.apply(itr)!=null)
                {
                    if(itr==rowSize-1){
                        newRow[itr] = Integer.parseInt(argRow1.apply(itr).toString())+Integer.parseInt(argRow2.apply(itr).toString());
                    }else{
                        newRow[itr] = argRow2.apply(itr);
                    }
                }
            }
        }

        return RowFactory.create(newRow);

    }

}, new Function2<Row,Row,Row>(){
    private static final long serialVersionUID = 1L;

    public Row call(Row v1, Row v2) throws Exception {
        // TODO Auto-generated method stub
        return v1;
    }
});

JavaRDD<Row> result1 = result.map(new Function<Tuple2<String,Row>, Row>() {
    private static final long serialVersionUID = -5480405270683046298L;
    public Row call(Tuple2<String, Row> rddRow) throws Exception {
        return rddRow._2();
    }
});