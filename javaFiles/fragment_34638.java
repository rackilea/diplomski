runOnUiThread(new Runnable() {  
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    txtName.setText(product.getString(TAG_DESCRIPTION));
                }