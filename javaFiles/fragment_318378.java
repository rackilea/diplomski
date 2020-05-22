private int[] imageResIdcolor = {
                                    R.drawable.ic_dashboard,
                                    R.drawable.ic_chats,
                                    R.drawable.ic_friends,
                                    R.drawable.ic_contacts,
                            };

        private int[] imageResId = {
                            R.drawable.ic_dashbordblue,
                            R.drawable.ic_chatsblue,
                            R.drawable.ic_friendsblue,
                            R.drawable.ic_contactsblue,
                    };

        @Override
        public void onTabSelected(TabLayout.Tab tab) {

   tabLayout.getTabAt(tab.getPosition()).setIcon(imageResId[tab.getPosition()]);
              }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
         tabLayout.getTabAt(tab.getPosition()).setIcon(imageResIdcolor[tab.getPosition()]);
             }