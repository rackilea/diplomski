private boolean checkLicense (String licenseNumber) {
   for(int i = 0; i < (realtorList.size() - 1); i++) {
      if (licenseNumber.equals(realtorList[i].getLicenseNumber())) {
         return true;
      }
   }
   return false;
}