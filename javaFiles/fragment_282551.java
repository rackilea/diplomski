boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
if (tabletSize) {
    Intent i = new(context, TabletActivity.class);
    startActivity(i);
} else {
    Intent i = new(context, MobileActivity.class);
    startActivity(i);
}