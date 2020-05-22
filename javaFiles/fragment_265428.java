case R.id.home_id:
                fragmentTransaction =   getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container, new   HomeFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Home Fragment");
                item.setChecked(true);
                drawerLayout.closeDrawers();
                break;