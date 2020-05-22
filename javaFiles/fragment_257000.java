System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
System.out.println("Borrowed? (should be false): " + example.isBorrowed());
example.borrowed();
System.out.println("Borrowed? (should be true): " + example.isBorrowed());
example.returned();
System.out.println("Borrowed? (should be false): " + example.isBorrowed());