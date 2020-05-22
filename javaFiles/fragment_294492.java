@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
    if(tab.getTag().toString().equals("LOGIN_TAB")){

        if(registerLoginFragment == null){
            registerLoginFragment = Fragment.instantiate(this, RegisterLoginFragment.class.getName());
            ft.add(R.id.linearLayoutRegister, (Fragment)registerLoginFragment);
        }
        else{
            //ft.attach((Fragment)registerLoginFragment);
            registerLoginFragment.getView().setVisibility(View.VISIBLE);
        }


        currentFragment = registerLoginFragment;
    }
    else if(tab.getTag().toString().equals("PERSONAL_TAB")){
        if(registerPersonalFragment == null){
            registerPersonalFragment = Fragment.instantiate(this, RegisterPersonalFragment.class.getName());
            ft.add(R.id.linearLayoutRegister, (Fragment)registerPersonalFragment);
        }
        else{
            //ft.attach((Fragment)registerPersonalFragment);
            registerPersonalFragment.getView().setVisibility(View.VISIBLE);
        }

        currentFragment = registerPersonalFragment;
    }

}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    if(currentFragment != null){
        //ft.detach((Fragment)currentFragment);
        currentFragment.getView().setVisibility(View.GONE);
    }

}