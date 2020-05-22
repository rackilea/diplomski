Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            trx1 = bundle.getString("trx1");
            trx2 = bundle.getString("trx2");
            trx3 = bundle.getString("trx3");
            trx4 = bundle.getString("trx4");
        }


        StringBuilder stringBuilder= new StringBuilder();

        if(!TextUtils.isEmpty(trx1)){
            stringBuilder.append(trx1+",");
        }
        if(!TextUtils.isEmpty(trx2)){
            stringBuilder.append(trx2+",");
        }
        if(!TextUtils.isEmpty(trx3)){
            stringBuilder.append(trx3+",");
        } if(!TextUtils.isEmpty(trx4)){
            stringBuilder.append(trx4);
        }
       String normorTrx =stringBuilder.toString();