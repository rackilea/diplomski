ResultSet resultSet = statement.executeQuery(sql);
        LinkedList<Object> list = new LinkedList<Object>();
        list.add("Outlet");
        list.add("Amount");
        mainList.add(list);
while (resultSet.next()) {
        String[] keys= {"CashAmt","SwiggyAmt","KBAmt", "BigBasketAmt","ZomatoAmt","OMC","CBOnline","DineOut", "SodexoCpnCrd", "PhonePe", "Mobikwiki", "CreditCardAmt", "CouponAmt", "PayTMAmt", "CreditAmt"}; 

        for (String s: keys) { // iterate over all keys
           list = new LinkedList<Object>();
           list.add(s);
           list.add(resultSet.getLong(s));
           mainList.add(list);
        }
        String str = gson.toJson(mainList);

    }
    response.setContentType("application/json");
    System.out.println(str);