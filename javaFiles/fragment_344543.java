DataHolder holder;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
      super.onActivityCreated(savedInstanceState);
      holder = DataHolder.getInstance();   //get instance of DataHolder
      name.setText(holder.getName());     //get customer name by getName()
      // do the same for all fields
      HKIDNumber.setText(holder.getIdNumber());
      getEmail.setText(holder.getEmail());
      phone.setText(holder.getPhNumber());
    }