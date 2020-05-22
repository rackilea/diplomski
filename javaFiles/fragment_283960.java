try {
    android.content.pm.PackageInfo info = getPackageManager().getPackageInfo(
            "com.apps.sonictonic",
            android.content.pm.PackageManager.GET_SIGNATURES);
    for (android.content.pm.Signature signature : info.signatures) {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        android.util.Log.d("KeyHash", "KeyHash:" + android.util.Base64.encodeToString(md.digest(),
                android.util.Base64.DEFAULT));

    }
} catch (android.content.pm.PackageManager.NameNotFoundException e) {

} catch (java.security.NoSuchAlgorithmException e) {

}