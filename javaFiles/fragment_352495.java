private boolean checkLicense (String licenseNumber) {
        int i = licenses.indexOf(licenseNumber);
        if(i == -1) {
            return false;
        } else {
            return true;
        }
}