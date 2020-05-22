if (TextUtils.isEmpty(strBalance)) {
                Toast.makeText(TransactionSellINActivity.this, "Amount should not be empty", Toast.LENGTH_SHORT)
                        .show();
            } else if (strBalance.equalsIgnoreCase("0")) {
                Toast.makeText(TransactionSellINActivity.this, "Amount should not be Zero", Toast.LENGTH_SHORT)
                        .show();
            }
            else if(strBalance.indexOf("0")!=a.length()-1)
                {
                Toast.makeText(TransactionSellINActivity.this, "Amount Not Valid", Toast.LENGTH_SHORT)
                        .show();
                }
                else{
                    Toast.makeText(TransactionSellINActivity.this, "Amount  Valid", Toast.LENGTH_SHORT)
                        .show();
                }