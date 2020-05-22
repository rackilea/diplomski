for(int i=0; i<finishedEvents.size(); i++){
      Document toInsert = new Document("event_id", finishedEvents.get(i).getId());
      toInsert.append(Constants.PROP_EVENTFINISHED, finishedEvents.get(i).getEventStreaming().getEnd().getTime());
      toInsert.append(mongoTestData.getDataDescription(finishedEvents.get(i).getId()), Document.parse(mongoTestData.getData(finishedEvents.get(i).getId())));
      collection.insertOne(toInsert);
 }