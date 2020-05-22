propertyList = dbHelper.getAllProperties();
        dbHelper.closeDB();

        if(propertyList != null && propertyList.size() > 0) {
            noPropertyTxtView.setVisibility(View.GONE);
            adapter = new PropertyListAdapter(
                    PropertyListActivity.this, 
                    R.layout.row_property, propertyList, new ListItemBtnClickInterface() {

                        private int clickedPosition;

                        @Override
                        public void listItemBtnClickListener(Object obj, int viewId) {
                            // TODO Auto-generated method stub
                            clickedPosition = Integer.parseInt(obj.toString());
                            PropertyInfo addPropertyInfo = propertyList.get(clickedPosition);
                            final long propertyId = addPropertyInfo.getId();
                            switch (viewId) {
                            case R.id.editImgView:
                                Intent intent = new Intent(PropertyListActivity.this,
                                        AddPropertyActivity.class);
                                intent.putExtra(PortfolioManagementApplication.KEY_PROPERTY_ID, 
                                        propertyId);
                                startActivity(intent);
                                break;

                            case R.id.deleteImgView:
                                new AlertDialog.Builder(PropertyListActivity.this)
                                .setTitle(getResources().getString(R.string.delete_property_title))
                                .setIcon(R.drawable.delete_icon)
                                .setMessage(R.string.delete_property_msg).setCancelable(true)
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub
                                        dbHelper.deleteProperty(propertyId);
                                        dbHelper.closeDB();
                                        propertyList.remove(clickedPosition);
                                        adapter.notifyDataSetChanged();
                                        if (propertyList.size() == 0)
                                            noPropertyTxtView.setVisibility(View.VISIBLE);
                                        else
                                            noPropertyTxtView.setVisibility(View.GONE);
                                    }
                                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // TODO Auto-generated method stub

                                    }
                                }).show();
                                break;

                            default:
                                break;
                            }
                        }
                    });
            propertyListView.setAdapter(adapter);
            propertyListView.setOnItemClickListener(this);
        } else {
            noPropertyTxtView.setVisibility(View.VISIBLE);
        }