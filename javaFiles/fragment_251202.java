BasicDBObject query = new BasicDBObject(
            "idCab", 1)
            .append("cab", new BasicDBObject(
                    "$elemMatch", new BasicDBObject(
                            "idCat", categoria)))
            .append("fMod", new BasicDBObject("$gte", fechaInicio)
                    .append("$lt", fechaFin)
            );