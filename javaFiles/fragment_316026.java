default:
       return false;
     }
   }
 });
}


public void setFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = 
    getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.frame_utama, fragment);
    fragmentTransaction.commit();
}