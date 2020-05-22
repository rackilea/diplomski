PackageManager packageManager = context.getPackageManager();
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("http://www.google.com"));
    List<ResolveInfo> list = packageManager.queryIntentActivities(intent,
            PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo info : list) {
                String name = info.name;
            }