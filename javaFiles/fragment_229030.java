statement = select("distinct id, Season, Week") 
.from(i(bucketName.toString())).where(x("Season").eq(s(seasonId)).and(x("meta().id").like(s("TescoWeek%"))
                .and(x("Week").gte(s(startWeek)))))
                .orderBy(Sort.asc("Week")); 
        System.out.println(statement.toString());
        return couchBaseRepository.getQueryResultAsString(cluster, bucketName, statement);