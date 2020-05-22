class ViewModelFactory() : ViewModelProvider.Factory {

    override fun create(modelClass: Class): T {
        if (modelClass.isAssignableFrom(UserProfileViewModel::class.java)) {
            val key = "UserProfileViewModel"
            if(hashMapViewModel.containsKey(key)) {
                return getViewModel(key) as T
            } else {
                addViewModel(key, UserProfileViewModel())
            return getViewModel(key) as T
        }
    }
    throw IllegalArgumentException("Unknown ViewModel class")
    }

    companion object {
        val hashMapViewModel = HashMap<String, ViewModel>()

        fun addViewModel(key: String, viewModel: ViewModel) {
            hashMapViewModel.put(key, viewModel)
        }

        fun getViewModel(key: String): ViewModel? {
            return hashMapViewModel[key]
        }
    }
}