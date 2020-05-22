Collection firstList = new ArrayList() {{
    add("str1");
    add("str2");
}};

Collection secondList = new ArrayList() {{
    add("str1");
    add("str3");
    add("str4");
}};


System.out.println("First List: " + firstList);
System.out.println("Second List: " + secondList);

// Here is main part
secondList.removeAll(firstList);

System.out.println("Result: " + secondList);