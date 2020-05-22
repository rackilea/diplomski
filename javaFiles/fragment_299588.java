mongoClient.runCommand("aggregate", getTotalRecsPerTypeCommand(sellerId, collection), res -> {
    result.put("totalRecsPerType", res.result());
}).count(collection, new JsonObject().put("sellerId", sellerId), res -> {
    result.put("totalRecs", res.result());
    requestMessage.reply(result);
});