String str = new String("   .,,¨B<?xml version='1.0' encoding='UTF-8'?>  ");
    String str1 = str.replaceFirst("(.*)<?xml", "<?xml");
    String str2 = str.trim().replaceFirst("(.*)<?xml", "<?xml");

    System.out.println(str1 + "|");
    System.out.println(str2 + "|");