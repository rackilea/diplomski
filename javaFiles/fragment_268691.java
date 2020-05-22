listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

          if (position == logOutIndex) { //You can do this if you know the position of the logOut button, e.g it's always at the end of the ListVIew

                ParseUser.logOut();
                navigateToLogin();
           }
        }
    });