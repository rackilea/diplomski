private fun getBeersProperties() {
coroutineScope.launch {
    var getPropertiesDeferred =
        BreweryApi.retrofitService.getProperties("13e9caaf80adac04dce90ef55600d898")
    try {
        _status.value = BreweryApiStatus.LOADING
        val listResult = getPropertiesDeferred.await()
        listResult.data?.let {
            _status.value = BreweryApiStatus.DONE
            _properties.value = it
        } ?: let {
            _status.value = BreweryApiStatus.ERROR
            _properties.value = ArrayList()
        }
    } catch (e: Exception) {
        _status.value = BreweryApiStatus.ERROR
        _properties.value = ArrayList()
    }
}