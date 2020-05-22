list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               selectedItem=new Items();

          Items getItms=(Items)parent.getItemAtPosition(position);

            selectedItem.ItemCode=getItms.ItemCode;
            selectedItem.ItemName=getItms.ItemName;
            selectedItem.Price=getItms.Price;

                selectedItemName=selectedItem.ItemName;
                selectedItemPrice=selectedItem.Price;
                itemName.setText(selectedItemName);
                itemPrice.setText(String.valueOf(selectedItemPrice));

                quantPlus.setEnabled(true);
                quantMinus.setEnabled(true);
                quantCount=1;
                quantity.setText(String.valueOf(quantCount));
                addItem.setEnabled(true);
               // Toast.makeText(getActivity().getApplicationContext(),selectedItem, Toast.LENGTH_LONG).show();
            }
        });