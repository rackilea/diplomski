List<Key<MXChallenge>> keyList = new ArrayList<>();
List<Key<MXChallenge>> searchInKeys = ofy().load().type(MXChallenge.class).keys().list();

for(Long id : alreadyRetrieved){
    keyList.add(Key.create(MXChallenge.class, id));
}

searchInKeys.removeAll(keyList);

QueryResultIterator<MXChallenge> iteratorChallenges = ofy().load()
        .type(MXChallenge.class).filter("colour", "blue").filterKey("IN", searchInKeys).iterator();