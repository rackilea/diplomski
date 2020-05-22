String str = "\"json_value\": \"{\\\"screen\\\":\\\"SCR-3\\\",\\\"price\\\":\\\"200\\\",\\\"count\\\":\\\"0\\\",\\\"name\\\":\\\"Regular Cup, Delishy 50 Ml\\\",\\\"seat_num\\\":\\\"D12\\\",\\\"image\\\":\\\"http://192.168.2.46:8080/OrderSnacks/JSON_images/icecream_cup_vanilla.jpg\\\",\\\"quantity\\\":\\\"2\\\",\\\"orderid\\\":\\\"14070738\\\",\\\"itemid\\\":\\\"57\\\",\\\"vendor_id\\\":\\\"10101500072001001\\\",\\\"date_time\\\":\\\"13:07:38\\\",\\\"toppings\\\":[{\\\"name\\\":\\\"Quantity      1\\\",\\\"value\\\":[\\\"Honey with Chocolate Sauce  10 ML\\\"]},{\\\"name\\\":\\\"Quantity      2\\\",\\\"value\\\":[\\\"Honey with Chocolate Sauce  10 ML\\\"]}]}\",";


  str =   str.replaceAll("\\\\", "");

  System.out.println(str);


 output: 


 "json_value": "{"screen":"SCR-3","price":"200","count":"0","name":"Regular Cup, Delishy 50 Ml","seat_num":"D12","image":"http://192.168.2.46:8080/OrderSnacks/JSON_images/icecream_cup_vanilla.jpg","quantity":"2","orderid":"14070738","itemid":"57","vendor_id":"10101500072001001","date_time":"13:07:38","toppings":[{"name":"Quantity      1","value":["Honey with Chocolate Sauce  10 ML"]},{"name":"Quantity      2","value":["Honey with Chocolate Sauce  10 ML"]}]}",