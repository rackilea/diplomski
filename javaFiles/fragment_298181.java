class BookingClass {

    // You also seem to need the following:
    Booking aBooking;

    String title;
    String firstName;
    String lastName;
    String bookingNo;
    String roomType;

    private void createBooking() {

        System.out.print("Enter title: ");
        title = keyboard.next();
        System.out.print("Enter first name: ");
        firstName = keyboard.next();
        System.out.print("Enter last name: ");
        lastName = keyboard.next();
        System.out.print("Enter booking number: ");
        bookingNo = keyboard.next();
        System.out.print("Enter room type: ");
        roomType = keyboard.next();

        aBooking = new Booking(title, firstName, lastName, bookingNo, roomType);
    }

    public void printCustomerName() {
        System.out.println(title);
        // ...should perhaps be
        // System.out.println(firstName + " " + lastName);
    }
}