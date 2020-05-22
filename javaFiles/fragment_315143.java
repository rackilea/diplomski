private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment=new Information();
                break;
            case 1:
                fragment=new Claims();
                Bundle bundle=new Bundle();
                bundle.putLong("ab",WorkDetails.ab);
                fragment.setArguments(bundle);
                break;

            case 2:
                fragment=new Project();
                break;

            case 3:
                fragment=new Report();
                break;

            case 4:
                fragment=new ViewView();

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();

            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
}