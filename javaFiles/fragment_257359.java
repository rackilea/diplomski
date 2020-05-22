Date d = makeMeAnObjectPlease();
System.out.println(d);
Date d2 = d;
changeMyObjectPlease(d2);
System.out.println(d);
System.out.println(d2);

Date makeMeAnObjectPlease() {
    return new Date();
}

void changeMyObjectPlease(Date date) {
    date.setTime(1234);
}