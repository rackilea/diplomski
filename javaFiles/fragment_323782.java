Hotel h1 = new Hotel(100);
System.out.print(h1.getRoomNr() + " "); // 100
Hotel h2 = doStuff(h1);
System.out.print(h1.getRoomNr() + " "); // 100 - h1 is not changed, h2 is a distinct new object
System.out.print(h2.getRoomNr() + " "); // 1
h1 = doStuff(h2);
System.out.print(h1.getRoomNr() + " "); // 1 - h1 is now changed, h2 not
System.out.print(h2.getRoomNr() + " "); // 1