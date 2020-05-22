val isOnline: Boolean
        get() {
            return try {
                val connectivityManager = context.getSystemService(
                        Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                connectivityManager.activeNetworkInfo != null &&
                        connectivityManager.activeNetworkInfo.isConnected
            } catch (exception: Exception) {
                false
            }
        }