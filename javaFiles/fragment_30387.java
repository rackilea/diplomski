public class Activity implements CustomArrayAdapter.MenuListener {

    private MenuItem menuItem; // The menu item that you wanna show/hide

    ....

    @Override
    public void onCreate(Bundle savedInstanceState) {

        CustomArrayAdapter adapter = new CustomArrayAdapter(params...);
        adapter.setMenuListener(this);
        // Set listView adapter
    }

    @Override 
    public boolean onCreateOptionsMenu(Menu menu)
    { 
        menuItem = menu.findItem(R.id.menuItemId); // Save the menu item that you want to show/hide later
        ...
    }

    @Override
    public void setMenuItemVisible(boolean state) {
        menuItem.setVisible(state);
    }
}