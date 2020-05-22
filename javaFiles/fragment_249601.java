Locale locale = new Locale("lt");
Resources res = getResources();
android.content.res.Configuration conf = res.getConfiguration();
DisplayMetrics dm = res.getDisplayMetrics();
conf.locale = locale;
res.updateConfiguration(conf, dm);