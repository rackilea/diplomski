public View getView(final int position, View convertView, ViewGroup arg2) {
        final ViewHolderGrid holderForGrid;
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.catalog_list_item, null);
            holderForGrid = new ViewHolderGrid(convertView);
            convertView.setTag(holderForGrid);

        } else {
            holderForGrid = (ViewHolderGrid) convertView.getTag();
        }

        finalCatalogVariables catalog = catalogList.get(position);

        if(catalog.isAdded()){
             holderForGrid.AddtoCart.setText("Added");
        }else{
              holderForGrid.AddtoCart.setText("Add to cart");
        }

        holderForGrid.AddtoCart.setClickable(false);


        holderForGrid.AddtoCart.setTag(position);

        holderForGrid.AddtoCart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                catalog.setAdded(true);    

                 int position1=(Integer)arg0.getTag();

                AddedProduct = (String) holderForGrid.CatalogHeader.getText();
               // holderForGrid.AddtoCart.setText("Added");


            }
        });
        return convertView;
    }