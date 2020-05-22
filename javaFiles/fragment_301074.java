TinyDB tinydb=new TinyDB(getActivity().getApplicationContext());

    incometemp = edttxt.getText().toString();
    mylist= tinydb.getListString("income");
    mylist.add(incometemp );
    tinydb.putListString("income", mylist);