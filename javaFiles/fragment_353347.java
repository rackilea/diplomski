public void createShortCut{
    Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    shortcutintent.putExtra("duplicate", false);
    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.shortcutname));
    Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext, R.drawable.icon);
    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent("com.whatsapp"));
    sendBroadcast(shortcutintent);
}