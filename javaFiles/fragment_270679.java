public void GenerateGCMID(){
    GCMClientManager pushClientManager = new GCMClientManager(this, "921544902369");
    pushClientManager.registerIfNeeded(new GCMClientManager.RegistrationCompletedHandler() {
        @Override
        public void onSuccess(String registrationId, boolean isNewRegistration) {
            ID = registrationId;
            Log.e("reg",ID);
        }
        @Override
        public void onFailure(String ex) {
            super.onFailure(ex);
        }
    });
}