private boolean isInMailLayout = true;
[...]
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    if(isInMainLayout){
        setContentView(R.layout.settings);
        isInMailLayout = false;
    }
    else {
        setContentView(activity_mail.xml);
        isInMailLayout = true;

    }

    return true;
}