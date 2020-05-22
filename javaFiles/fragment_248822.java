@Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setTitle("Tests");
                        bottomNavigationView.setSelectedItemId(R.id.navigation_tests);
                        break;
                    case 1:
                        setTitle("Courses");
                        bottomNavigationView.setSelectedItemId(R.id.navigation_courses);
                        break;
                    case 2:
                        setTitle("Profile");
                        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
                        break;
                    case 3:
                        setTitle("Leaderboard");
                        bottomNavigationView.setSelectedItemId(R.id.navigation_leaderboard);
                        break;
                    case 4:
                        setTitle("Settings");
                        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
                        break;
                }
            }