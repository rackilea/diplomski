final int uniqueID = 12345;
MenuItem addedMenuItem = this.filterMenu.getMenu().add(R.id.orders_filter_messages_group, uniqueID, Menu.NONE, channel.getName());

//and in the onClickListener
filterMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick (MenuItem item) {
                if(item.getItemId() == uniqueID) //TODO
                return false;
            }
        });