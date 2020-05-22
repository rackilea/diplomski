List<String> list = Arrays.asList("varun", "akash", "shakshi", "gowtham", "VARUN");

list.sort(null); // Natural order: [VARUN, akash, gowtham, shakshi, varun]
System.out.println(list);

list.sort(String.CASE_INSENSITIVE_ORDER); // [akash, gowtham, shakshi, VARUN, varun]
System.out.println(list);

list.sort(String.CASE_INSENSITIVE_ORDER.reversed()); // [VARUN, varun, shakshi, gowtham, akash]
System.out.println(list);

list.sort(Collator.getInstance().reversed()); // [VARUN, varun, shakshi, gowtham, akash]
System.out.println(list);