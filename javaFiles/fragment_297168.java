for (int i = 0; i < Integer.parseInt(validtotal_order); i++) {
     if(sn.hasMoreElements())
       {
            list_order item = new list_order(st.nextToken(),sc.nextToken(),sn.nextToken());//Error
            rowitems.add(item);
       }
    }