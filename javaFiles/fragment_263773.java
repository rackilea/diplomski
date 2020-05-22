for (Object object : data) {

      Map row = (Map) object;
      System.out.print(row.get("0"));
      System.out.print("\t" + row.get("1"));
      System.out.print("\t" + row.get("2"));

   }