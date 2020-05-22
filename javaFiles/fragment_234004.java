@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        // TODO Auto-generated method stub
        PropertyInfo addPropertyInfo = propertyList.get(position);
        long propertyId = addPropertyInfo.getId();
        Intent intent = new Intent(PropertyListActivity.this,
                AddPropertyActivity.class);
        intent.putExtra(PortfolioManagementApplication.KEY_PROPERTY_ID, 
                propertyId);
        startActivity(intent);
    }