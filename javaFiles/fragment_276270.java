List<?> list = context.getBean("aList", List.class);
List<?> list2 = context.getBean("aList", List.class);

System.out.println(list);
System.out.println(list2);
System.out.println(list == list2);