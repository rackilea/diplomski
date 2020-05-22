void onCreate(Bundle savedInstanceState) { 
   super.onCreate(savedInstanceState);
   DaggerMainComponent.builder()
       .netComponent(((App)getApplication())
       .mainPresenterModule(new SampleMainPresenterModule(this, this))
       .build() 
       .inject(this);