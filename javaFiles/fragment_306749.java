final Intent i = new Intent(); //intent for the shortcut
final Intent shortcutIntent = new Intent( /*put necessary parameters (i.e activity to launch)*/ );
shortcutIntent.putExtra(Browser.EXTRA_APPLICATION_ID /*if your launching a browser*/,
        Long.toString(/*put unique id e.g. system time etc.*/));
i.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
i.putExtra(Intent.EXTRA_SHORTCUT_NAME, /*title*/);
i.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,/*drawable*/);
i.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
sendBroadcast(i);