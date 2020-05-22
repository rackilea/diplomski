SQLSubQuery subQuery = new SQLSubQuery();
subQuery = subQuery.from(t).join(t.fk462bdfe3e03a52d4, QClient.client);
ListSubQuery clientByPaid = subQuery.list(t.id.as("id"), t.paidId.as("clientid"),
                                QClient.client.name.as("clientname"));

subQuery = new SQLSubQuery();
subQuery = subQuery.from(t).where(t.paidId.isNull(), t.clientname.isNotNull());
ListSubQuery clientByName = subQuery.list(t.id, Expressions.constant(-1L), 
                                  t.clientname);