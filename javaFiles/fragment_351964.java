public void handleResult(String rawResult) {    
            if(Utility.isNotNull(rawResult.getText().toString())) {
                for(int i=0;i<listView.getAdapter().getCount();i++){
                    if(rawResult.equals(listItems.get(i).getStockItems())){   
                        listItems.get(i).setIsSelected(1);
                        adapter.notifyDataSetChanged();                                                      
                    }
                }
            }
        }