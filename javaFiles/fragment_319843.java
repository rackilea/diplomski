//creating a popup menu
PopupMenu popup = new PopupMenu(context, holder.addresslistmenu);
//inflating menu from xml resource
popup.inflate(R.menu.addressmenu);
//adding click listener
popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.addresslistupdatemenu:
                                yourfunction()
                                break;
                        }
                        return false;
                    }
                });
//displaying the popup
popup.show();