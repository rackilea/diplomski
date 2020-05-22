private DaggerTestClass daggerTestClass; // note: no @Inject here

// …

// Inject other dependencies into the activity
IndexApplication.getApplication().getAppComponent().inject(this);
// "manually inject" the DaggerTestClass
this.daggerTestClass = IndexApplication.getApplication().getAppComponent()
    .daggerTestFactory().create("arg1", 2, true);