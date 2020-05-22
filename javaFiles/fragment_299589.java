mongoClient.runCommand("aggregate", getTotalRecsPerTypeCommand(sellerId, collection), res -> {
        result.put("totalRecsPerType", res.result());
        requestMessage.reply(result);
    }).count(collection, new JsonObject().put("sellerId", sellerId), res -> {
        result.put("totalRecs", res.result());
    });