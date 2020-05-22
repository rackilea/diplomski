KsDef ksdef = new KsDef();
ksdef.name = ksname;
ksdef.strategy_class = SimpleStrategy.class.getName(); 

//Set replication factor
if (ksdef.strategy_options == null) {
    ksdef.strategy_options = new LinkedHashMap<String, String>();
}

//Set replication factor, the value MUST be an integer
ksdef.strategy_options.put("replication_factor", "1");

//Cassandra must now create the Keyspace based on our KsDef
client.system_add_keyspace(ksdef);