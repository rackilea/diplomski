Collection<String> firstList = new ArrayList<String>();
firstList.add("str1");
firstList.add("str2");

Collection<String> secondList = new ArrayList<String>();
secondList.add("str1");
secondList.add("str2");
secondList.add("str3");


System.out.println("First List: " + firstList);
System.out.println("Second List: " + secondList);

// Here is main part
secondList.removeAll(firstList);