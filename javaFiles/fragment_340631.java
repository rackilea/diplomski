public void onBindViewHolder(DaysAdapter.ViewHolder viewHolder, int position) {
    Menu menuItem = mMenuItems.get(position);
    viewHolder.daysMenu.setText(menuItem.mDay);
    viewHolder.soupMenu.setText(menuItem.mSoup);
    viewHolder.nonVegMainMenu.setText(menuItem.mNonVegMain);
    }