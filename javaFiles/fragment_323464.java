expiration = expnum.nextInt();
DateFormat dateformat = new SimpleDateFormat("MMyy");
Date expiryDate = dateFormat.parse(expiration);

Date currentDate = new Date();

if (currentDate.isAfter(expiryDate)) {
   // card has expired
} else {
   // card is still active
}