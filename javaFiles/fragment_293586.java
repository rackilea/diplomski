List<DBObject> aggregates = Arrays.asList(new BasicDBObject("$project", new BasicDBObject("dt", "$dt").
            append("mc", "$mc").
            append("uplift", "$uplift").
            append("baseAvg", "$baseAvg").
            append("baseUp", new BasicDBObject("$add", Arrays.<Object>asList("$uplift", "$baseAvg"))).
            append("share", new BasicDBObject("$cond", Arrays.<Object>asList(new BasicDBObject("$eq", Arrays.<Object>asList("$baseAvg", 0)),
                    0, new BasicDBObject("$divide",  Arrays.<Object>asList("$uplift", "$baseAvg")))))));