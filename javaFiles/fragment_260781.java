private fun accessTokenLiveData() {
                timeSettingViewModel.accessTokenLiveData.observe(this, android.arch.lifecycle.Observer {
                    if (it != null) {
                        updateLoginView(it)
                    }
                })
                timeSettingViewModel.getAccessToken()
    }