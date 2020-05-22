if(hasFocus){
    frame.postDelayed(new Runnable() {

    @Override
        public void run() {
            // TODO Auto-generated method stub
     fragment = new ViewDetail();
     fragmentManager = getFragmentManager(); 
     ft = fragmentManager.beginTransaction(); 
    ft.setCustomAnimations(R.animator.trans_left_in,R.animator.trans_left_out);
    ft.addToBackStack(null); 
    ft.replace(R.id.container, fragment, "Dettaglio"); 
    ft.commit();//the error is here


        }
    }, 500);
  }