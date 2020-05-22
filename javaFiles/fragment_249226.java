mFirestore.collection("catend").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {

                if (e != null) {
                    Log.d(TAG, "onEvent: error" + e.getMessage());
                }
                for (DocumentChange document : documentSnapshots.getDocumentChanges()) {
                    switch (document.getType()) {
                        case ADDED:
                            ProductTest productModel=document.getDocument().toObject(ProductTest.class);
                            Log.d(TAG, "onEvent: response"+document.getDocument().getData());
                            Log.d(TAG, "onEvent: code="+productModel.getCode());  //work
                            Log.d(TAG, "onEvent: description="+productModel.getDesc()); //work
                            Log.d(TAG, "onEvent: name="+productModel.getName()); //work
                            Log.d(TAG, "onEvent: packs"+productModel.getPacks()); //Work
                            for (int i = 0; i <productModel.getPacks().size() ; i++) {
                                try {
                                    JSONObject jsonObject=new JSONObject(productModel.getPacks().get(i).toString());
                                    Log.d(TAG, "onEvent: subcode= "+jsonObject.getString("subcode"));
                                    Log.d(TAG, "onEvent: subprice="+jsonObject.getString("price"));
                                    Log.d(TAG, "onEvent: weight="+jsonObject.getString("weight"));

                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }
                            }

                            break;
                        case REMOVED:
                            break;
                        case MODIFIED:
                            break;
                    }

                }

            }
        });