private void installShortcut() {
    final Intent shortcutIntent = new Intent(getApplicationContext(), MainActivity.class);
    shortcutIntent.setAction(Intent.ACTION_MAIN);
    shortcutIntent.addCategory(Intent.CATEGORY_LAUNCHER);
    shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

    final Intent intent = new Intent();
    intent.putExtra("duplicate", false);
    intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
    intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
    intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
    intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    sendBroadcast(intent);
}