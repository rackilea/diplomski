public native String takeInfo(String nt_domain, String nt_id, String nt_idca, String nt_password, String[] error);

boolean canLogin = takeInfo(domain, userID, "", userPass, error);
if(!canLogin){
   String message = error[0];
}