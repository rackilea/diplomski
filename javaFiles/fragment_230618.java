if (mEventsMap.containsKey(findBaseMEvent)) {
      // just update the enclosed list
      mEventsMap.get(findBaseMEvent).add("Whatever you want");            
} else {
      // create new entry
      mEventsMap.put(findBaseMEvent , mEventDtoList);
}