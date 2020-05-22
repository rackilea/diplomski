@Override
public void onBackPressed() {
      if (getSupportFragmentManager().getBackStackEntryCount() != 0){
            super.onBackPressed();
      }else{
            if (isFirstBackPressed) {
                  super.onBackPressed();
             } else {
            isFirstBackPressed = true;
            showMessage("Press back again to exit");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isFirstBackPressed = false;
                }
            }, 1500);
        }
    }
  }