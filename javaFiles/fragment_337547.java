Title title1 = new Title();
title1.setTitleId(new Integer(1));
title1.setName("Mr");

Title title2 = new Title();
title2.setTitleId(new Integer(1));
title2.setName("Mr");

System.out.println( title1 == title1 );       // will return true
System.out.println( title1.equals( title2 )); // will return false