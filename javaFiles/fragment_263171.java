@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getId(); // Retrieve the id of the selected menu item

    switch(id) {
        case R.id.about: // "@+id/about" is the id of your menu item (menu layout)
            doThis(item);
            return true;
            break;
        case ...
    }
    return super.onOptionsItemSelected(item);
}