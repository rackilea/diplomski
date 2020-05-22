override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.let {
            ViewCompat.requestApplyInsets(it)
        }
    }