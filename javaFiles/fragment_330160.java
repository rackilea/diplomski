StringBuilder sb = new StringBuilder();
    sb.append("Insert into document (T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,vendor_brand_id,vendor_id) values (");
    for (int i = 0; i < 10; i++) {
        if (i < valuess.length) {
            sb.append("'" + valuess[i] + "',");
        } else {
            sb.append("NULL,");
        }
    }
    sb.append(vendor_brand_id+","+vendor_id+")");

    //now sb.toString() is ready for required sql
    System.out.println(sb.toString());