public class ChangethemeActivity extends AppCompatActivity{

@Override
protected void onCreate(@Nullable Bundle savedInstanceState){
    super.onCreate(savedInstanceState);

    //get your theme name using sharedpreference and check what you have saved in theme name value

    if(dark){
    setTheme(ThemeUtil.getThemeId(1));
    }
    else{
      setTheme(ThemeUtil.getThemeId(2));
    }  }}}