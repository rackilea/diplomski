@Override
protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    ACRA.init(this, new ConfigurationBuilder(this).build(), false);
    MultiDex.install(this);
}