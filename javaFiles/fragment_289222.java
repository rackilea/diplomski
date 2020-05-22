public boolean onContextItemSelected(MenuItem item) { //what to do when menu item clicked in context menu
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        deleteGoal(info.position);
        return true;

    }