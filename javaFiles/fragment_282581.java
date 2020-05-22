for(int ii=0;ii<StocklistAdapter.listItemN.size();ii++){
JSONObject ItemsRequiredob=new JSONObject();

                ItemsRequiredob.put("ItemID",StocklistAdapter.itemIdN.get(ii));
                ItemsRequiredob.put("StockCode",StocklistAdapter.listItemN.get(ii));
                Toast.makeText(this, "StockCode"+StocklistAdapter.listItemN.get(ii), Toast.LENGTH_SHORT).show();
                ItemsRequiredob.put("Description",StocklistAdapter.listAddressN.get(ii));
                ItemsRequiredob.put("Quantity",StocklistAdapter.QuaN.get(ii));

                ItemsRequiredobArr.put(ItemsRequiredob);


                        /*Toast.makeText(mContext, "i"+i+" "+listAddressN.get(i), Toast.LENGTH_SHORT).show();*/
                    Log.e("d", ItemsRequiredob.get("ItemID").toString());


            }