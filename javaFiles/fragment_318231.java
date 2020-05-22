Base base3 = new Base("012");
Base base6alpha = new Base("ABCDEF");
System.out.println(base3.convertTo(base6alpha, "0"));   // 0  -> A
System.out.println(base3.convertTo(base6alpha, "2"));   // 2  -> C
System.out.println(base3.convertTo(base6alpha, "10"));  // 3  -> D
System.out.println(base3.convertTo(base6alpha, "200")); // 18 -> DA