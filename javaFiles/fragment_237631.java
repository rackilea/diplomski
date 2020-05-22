class MyViewModelStore : ViewModelStore() {

  private val mMap = HashMap<String, ViewModel>()

  internal fun put(key: String, viewModel: ViewModel) {
    val oldViewModel = mMap.put(key, viewModel)
    oldViewModel?.onCleared() // COMPILATION ERROR -> Cannot access 'onCleared': it is protected/*protected and package*/ in 'ViewModel'
  }

  internal operator fun get(key: String): ViewModel? {
    return mMap[key]
  }

  override fun clear() {
    for (vm in mMap.values) {
      vm.onCleared() // COMPILATION ERROR -> Cannot access 'onCleared': it is protected/*protected and package*/ in 'ViewModel'
    }
    mMap.clear()
  }

}