runOnUiThread(new Runnable() {  
                    @Override
                    public void run() 
                    {
                        // TODO Auto-generated method stub
                        try {


                            txt3.setText(product.getString(TAG_DESCRIPTION));

                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });

            }else{
                // product with pid not found
            }