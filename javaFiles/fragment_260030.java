BasicDBObject fields = new BasicDBObject("_id","$stream.name" );
 if (error1)
    fields.append("error1",new BasicDBObject ("$sum","$stream.error1"));
 if (error2)
    fields.append("error2",new BasicDBObject ("$sum","$stream.error2"));
 if (error3)
    fields.append("error3",new BasicDBObject ("$sum","$stream.error3"));
BasicDBObject group = new BasicDBObject( "$group", fields);