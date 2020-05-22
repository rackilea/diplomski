public static boolean isValidEmailAddress(String emailAddress) {
   try {
       InternetAddress.parse(emailAddress, true);
       return true;
   } catch (Exception e) {
    return false;
   }

}