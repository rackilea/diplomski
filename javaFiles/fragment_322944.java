@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    getApp().addActivity(this); //add to thread controlled by Application
}

@Override
public void onDestroy()
{
    super.onDestroy();
    getApp().removeActivity(this); //remove from thread controlled by Application
}