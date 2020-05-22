case R.id.navigation_services:
//                    mTextMessage.setText(R.string.title_services);
                    CategoriesListFragment categoriesListFragment = new CategoriesListFragment();
                    fragmentTransaction.replace(R.id.frame, categoriesListFragment);
                    fragmentTransaction.commit();
                    return true;