StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = sb1;

    sb1.append("change thru sb1");
    sb2.append(" change thru sb2");

    // will print both modifications, since sb1 & sb2 refer to the same object
    System.out.println(sb1);