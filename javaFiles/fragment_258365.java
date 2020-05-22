public void popBackStackMethod(){
               if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    this.getChildFragmentManager().popBackStack();
                    disposableLayout.setVisibility(View.VISIBLE);
                } 
    }