@Override
public boolean onCreateOptionsMenu(Menu menu){
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.optionsmenu, menu);
    return true;
}


public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
        case R.id.menuHelp :
            return true;

        case R.id.menuShowInstallationCode :
            return true;

    }
    return super.onOptionsItemSelected(item);
}