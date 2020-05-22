Iterator<EntityResult> entity_interator = response.getBatch().getEntityResults().iterator();
Map<String, Property> entity;
while(entity_interator.hasNext()){
    entity = entity_interator.next().getEntity().getProperties();

    String first = entity.get("First").getValues().get(0).getStringValue();
    String last = entity.get("Last").getValues().get(0).getStringValue();
    DateTime dateTime = entity.get("Time").getValues().get(0).getDateTimeValue();
    Date time = new Date(dateTime.getValue());

    System.out.println(first);
    System.out.println(last);
    System.out.println(time);
}