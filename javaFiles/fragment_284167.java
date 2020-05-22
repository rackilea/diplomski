@Override
                public void onClick(DialogInterface dialog, int which) {
                    curProduct.selected = false;
                    AllProducts.removeProduct(curProduct);
                    MyTabActivity.setTab(0);
                }