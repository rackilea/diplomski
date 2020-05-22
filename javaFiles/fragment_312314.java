Query query = query(
                new Criteria().andOperator(
                        where("_id").is(conversation.getId()),
                        where("messages._id").is(message.getId())
                )
        );

mongoOps.upsert(query, new Update().set("messages.$.text", "coolest text"), Conversation.class);