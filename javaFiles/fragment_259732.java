@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()) {
        case R.id.profile_edit: 
            addPlan();
            return true;
        case R.id. menu_main_spinner:
            loadPlan();
            return true;
    }
}