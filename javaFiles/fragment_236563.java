static final MyClass something;

static {
    Config conf=SettingsManager.getSettings();
    MyClass obj=MyClassFactory.getInstance(conf);
    obj.setVodoo(true);
    something=obj;
}