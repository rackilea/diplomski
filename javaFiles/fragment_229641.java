Document updDocQuery = new Document("_id", "9999996978c9df5b02999999");

Document upDocValue = new Document("numberOfDownloads": "453")
                          .append("documents.downloads":"453");

Document upDocSet = new Document("$set",updDocValue);

collection.updateOne(upDocQuery,upDocSet);