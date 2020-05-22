...
for (int i = 0; i < intKeys.length; i++)
{
    Booking booking = bookingss.get(intKeys[i]);
    if (!booking.getMailing())
    {
        mail = false;
        break;
     }
}
....
for (int i = 0; i < intKeys.length; i++)
{
    // Some updating done here on "booking"
    ...     
    if (!mail)
    {
        ...
    }
    ...
  // Overwrite old map values with new ones
    bookings.put(intKeys[i], booking);
    mapFax.put(intKeys[i], booking);
}