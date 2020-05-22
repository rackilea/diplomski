...
// kitkat fixed (broke) content access; to keep the URIs valid over restarts need to persist access permission
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    final int takeFlags = data.getFlags() & Intent.FLAG_GRANT_READ_URI_PERMISSION;
    ContentResolver resolver = getActivity().getContentResolver();
    for (Uri uri : images) {
        resolver.takePersistableUriPermission(uri, takeFlags);
    }
}
...