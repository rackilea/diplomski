public class FirebaseIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseIDService";

    private SharedPreferences sharePrefs;
    private SharedPreferences.Editor edit;

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Intent intent = new Intent(FirebaseIDService.this, SaveFCMTokenService.class);
        intent.putExtra("TOKEN",refreshedToken);
        FirebaseIDService.this.startService(intent);
    }

}