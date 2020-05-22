public class UserSettingActivity extends AppCompatActivity{
MainActivity.MyCallBack callBack;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settingsactivity);
    callBack = MainActivity.mCallback;

    //this is sample code ..call this function when you want to update mainactivity
    callBack.refreshMainActivity();
}

}