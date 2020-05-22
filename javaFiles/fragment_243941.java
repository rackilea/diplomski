UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("orderId", "75246c41-02c7-48c4-8d4c-d202483e6d2b")
            .withReturnValues(ReturnValue.ALL_NEW).withUpdateExpression("set #createDate = if_not_exists (#createDate, :val1)")
            .withNameMap(new NameMap().with("#createDate", "createDate"))
            .withValueMap(new ValueMap().withNumber(":val1", 1));

    UpdateItemOutcome outcome = table.updateItem(updateItemSpec);