if (appWidgets != null) {
    final int count = appWidgets.size();
    for (int i = 0; i < count; i++) {
        final Widget launcherInfo = appWidgets.get(i);
        launcherInfo.hostView = null;
    }
}