if(getIntent().getExtras() != null)
     {
     // do your functionality with extras
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String address = bundle.getString("address");
        int status = bundle.getInt("status");
        textViewTitle.setText(name);
        textViewInfo.setText(address + " " + status);
     }

     else
      {
       // do whatever you want to do
      }