public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {   

        menu.add(1, 1, 1, "Share Animal Sound");
        menu.add(1, 2, 2, "Change Picture");
        menu.add(1, 3, 3, "Change Sound");

        menu.getItem(0).setOnMenuItemClickListener(this); 
        menu.getItem(1).setOnMenuItemClickListener(this); 
        menu.getItem(2).setOnMenuItemClickListener(this); 
    }