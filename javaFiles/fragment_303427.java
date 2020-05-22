public static LiveData<ArrayList<Object>> zipLiveData(LiveData<Object>... liveItems){
    final ArrayList<Object> zippedObjects = new ArrayList<>();
    final MediatorLiveData<ArrayList<Object>> mediator = new MediatorLiveData<>();
    for(LiveData<Object> item: liveItems){
        mediator.addSource(item, new Observer<Object>() {
            @Override
            public void onChanged(@Nullable Object o) {
                if(!zippedObjects.contains(o)){
                    zippedObjects.add(o);
                }
                mediator.setValue(zippedObjects);
            }
        });
    }
    return mediator;
}