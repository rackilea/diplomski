navigationView.setNavigationItemSelectedListener { menuItem ->
    // set item as selected to persist highlight
    menuItem.isChecked = true
    // close drawer when item is tapped
    drawerLayout.closeDrawers()

    // Add code here to update the UI based on the item selected
    // For example, swap UI fragments here

    true
}