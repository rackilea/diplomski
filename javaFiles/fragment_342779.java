ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(){
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if(currentUser != null) {
                mUserRef.child("online").setValue(ServerValue.TIMESTAMP);
            }
        }
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart(){
            //onstart action here
        }
}