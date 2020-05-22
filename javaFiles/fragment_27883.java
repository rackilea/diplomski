public NoteActivity()
{
    super();
    addFragment(new NoteFragment());
}

protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(targetContainer);
    // you will have to put a getter/setter in BackboneActivity or change access modifiers
    this.setTargetContainer(R.id.fragmentContainer); 
    fragmentManager = getSupportFragmentManager();
}