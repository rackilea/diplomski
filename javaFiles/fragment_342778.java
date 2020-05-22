ProcessLifecycleOwner.get().lifecycle.addObserver(object : LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop(){
            val currentUser = mAuth.getCurrentUser()
            if (currentUser != null) {
                mUserRef.child("online").setValue(ServerValue.TIMESTAMP)
            }
        }
    })