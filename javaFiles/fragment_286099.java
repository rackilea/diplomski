addressListView.setOnItemClickListener(new OnItemClickListener() {
    @Override
     public void onItemClick(AdapterView<?> parent, View arg1, int position, long id) {

     AddressResult fullObj = itemList.get(position);
        // fullObj.getType(); access like this
        // fullObj.getLine1();
        // fullObj.getLine2();
        // fullObj.getArea();
        // fullObj.getCity();
        // obj.getPincode();

     Toast.makeText(getActivity(), "You have chosen:" +
                                "\n" + fullObj.getType()+
                                "\n" + fullObj.getLine1()+
                                "\n" + fullObj.getLine2()+
                                "\n" + fullObj.getArea()+
                                "\n" + fullObj.getCity()+
                                "\n" + fullObj.getPincode(), Toast.LENGTH_LONG).show();
    }
  });