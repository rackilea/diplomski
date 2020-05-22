Object obj = getLastNonConfigurationInstance();
if (obj != null) {
    MyActivity deadActivity = (MyActivity)obj;
    this.foo = deadActivity.foo;
    this.bar = deadActivity.bar;
    ...
}