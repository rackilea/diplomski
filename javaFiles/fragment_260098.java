public void foo (String user, Date date) {
  for (Iterator<bookings> i = book.iterator(); i.hasNext();) {
    bookings b = i.next(); // Oops - forgot this line!
    if (user.equals(b.getuser()) && date.equals(b.getbooking())
        i.remove(); // Corrected this too!
  }
}