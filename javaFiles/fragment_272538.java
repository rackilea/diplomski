String[] contries = {"Russia", "Saudi_Arabia", "Egypt", "Uruguay"};
Collections.shuffle(Arrays.asList(contries));

String announceA1 = contries[0] + " VS  " + contries[1];
System.out.println(announceA1);
String announceA2 = contries[2] + " VS  " + contries[3];
System.out.println(announceA2);