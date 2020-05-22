Set missing = new HashSet(list1);
missing.removeAll(list2);
System.out.println("missing:" + missing);

Set extra = new HashSet(list2);
extra.removeAll(list1);
System.out.println("extra:" + extra);