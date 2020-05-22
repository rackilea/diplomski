@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    MenuItem menuItem = menu.findItem(R.id.button);
    AppCompatButton button = (AppCompatButton) menuItem.getActionView();
    button.setText("My Button");
    return super.onPrepareOptionsMenu(menu);
}