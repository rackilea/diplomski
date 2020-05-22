private void createSoket() {
    spref = getSharedPreferences("accountData", Context.MODE_PRIVATE);
    String sessiontoken = spref.getString("sessiontoken", "");
    String userId = spref.getString("userid", "");

    if(!(TextUtils.isEmpty(sessiontoken) || TextUtils.isEmpty(userId))) {
        try {

            IO.Options op = new IO.Options();
            op.forceNew = true;
            op.reconnection = true;
            op.query = "tok=" + sessiontoken + "&usr=" + userId;
            mSocket = IO.socket(Constants.serverAddress, op);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}