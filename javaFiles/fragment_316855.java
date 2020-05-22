Document match =  new Document(
    "$match", new Document("filePrefix",
        new Document("$in", docsSet)
    )
);
Document sort =  new Document("$sort", 
    new Document("filePrefix", 1).append("fileId", -1)
);
Document group =  new Document("$group" , 
    new Document("_id", "$filePrefix")
        .append("fileId",  new Document("$first", "$fileId")
        .append("fileName",  new Document("$first", "$fileName")
    )
);
Document project = new Document("$project",
    new Document("filePrefix", "$_id")
        .append("fileId", 1)
        .append("fileName", 1)
);