fun zipLiveData(vararg liveItems: LiveData<*>): LiveData<ArrayList<Any>> {
return MediatorLiveData<ArrayList<Any>>().apply {
    val zippedObjects = ArrayList<Any>()
    liveItems.forEach {
        addSource(it, { item ->
            if (! zippedObjects.contains(item as Any)) {
                zippedObjects.add(item)
            }
            value = zippedObjects
        })
    }
}}