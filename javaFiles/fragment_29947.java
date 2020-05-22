bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (menuItem.isChecked()) return false;

                switch (id)
                {
                    case R.id.navigation_home :
                        navController.navigate(R.id.action_global_navigation_home);
                        break;
                    case R.id.navigation_images :
                        navController.navigate(R.id.action_global_navigation_images);
                        break;
                    case R.id.navigation_videos :
                        navController.navigate(R.id.action_global_navigation_videos);
                        break;
                    case R.id.navigation_songs :
                        navController.navigate(R.id.action_global_navigation_songs);
                        break;
                    case R.id.navigation_notifications :
                        navController.navigate(R.id.action_global_navigation_notifications);
                        break;
                }
                return true;

            }
        });