catch(final JSchException jex){

    LOG.debug(session.getHostKey().getKey());
    final com.jcraft.jsch.Session finalSession = session;

    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            new MaterialDialog.Builder(MyActivity.this)
                    .title("Accept this host with fingerprint?")
                    .negativeText(R.string.cancel)
                    .positiveText(R.string.ok)
                    .content(finalSession.getHostKey().getFingerPrint(jsch))
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("target_hostkey", finalSession.getHostKey().getKey()).apply();
                        }
                    }).show();
        }
    });

}