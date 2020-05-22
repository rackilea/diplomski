CloudStorageAccount account = CloudStorageAccount.parse("connection string");
        CloudTableClient client = account.createCloudTableClient();

        CloudTable table = client.getTableReference("WADMetricsPT1MP10DV2S20191017");
        System.out.println(table.exists());
        System.out.println(table.getName());





        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        cal.add(Calendar.HOUR, -19);
        cal.add(Calendar.MINUTE,-21);
        Date date = cal.getTime();
//        SimpleDateFormat df = new  SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
//        date = df.parse(df.format(date));
//
        System.out.println(date.toString());



        String queryString = TableQuery.generateFilterCondition("Timestamp",TableQuery.QueryComparisons.GREATER_THAN_OR_EQUAL, date);

        TableQuery<TableServiceEntity> query = TableQuery.from(TableServiceEntity.class).where(queryString);
        Iterable<TableServiceEntity> results = table.execute(query);
        int i=0;
        for (TableServiceEntity  entity:results
             ) {
            i +=1;
            System.out.println(entity.getPartitionKey());
        }

        System.out.println(i);