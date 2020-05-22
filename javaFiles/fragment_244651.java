@Override
public void onRemoteVideoStateChanged(final int uid, int state, int reason, int elapsed) {
    super.onRemoteVideoStateChanged(uid, state, reason, elapsed); 

    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            // The check actually does not provide uniqueness. It justs check with the previous uid as far as I could understand. If you want uniqueness, then you might have to store all the values previously seen in a HashMap and look for the uid in the HashMap. 
            if (UIDProvider.isDifferentThanStoredUid(uid)) {
                Log.d("TAG", "previous_uid = " + previous_uid + "  uid = "+ uid );
                setupRemoteVideo(uid);
            }
        }
    });            
}