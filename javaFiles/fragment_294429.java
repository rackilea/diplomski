String str = "9035";
  while (rs.next()) {
        String areaCode = rs.getString("AreaCode");
        if(str.equals(areaCode)){
           System.out.println("!!!!!!It matched: " + str);
           break;
        } else {
           System.out.println("No match with: " + areaCode);
        }
  }