Button button = (Button) view.findViewById(R.id.button2);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

          ButtonFragment fragment = new ButtonFragment();
          if (fragment != null && fragment.isVisible()) {



              FragmentManager fragmentManager = getFragmentManager();

              FragmentTransaction transaction =  fragmentManager.beginTransaction(); 
              transaction.remove(fragmentManager.findFragmentById(R.layout.activity_main)).commit();

          }
          else if(!fragment.isVisible())
          {
              FragmentManager fragmentManager = getFragmentManager();

              FragmentTransaction transaction =  fragmentManager.beginTransaction(); 
              transaction.add(R.layout.activity_main, fragment ).commit();
          }       

      }
    });