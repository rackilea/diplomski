User u1 = new User();
User u2 = new User();
Booking b = new Booking(authorKey1);
b.addObserver(u1);
b.addObserver(u2);
b.refreshAccess(); // u1 and u2 get notified

b.deleteObserver(u2); // you might want to override this to notify user remove booking info
b.refreshAccess(authorKey2); // u1 get notified