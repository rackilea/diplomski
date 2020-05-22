@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.secondary_layout);
    setTaskDescription(new ActivityManager.TaskDescription("Activity 2"));
}