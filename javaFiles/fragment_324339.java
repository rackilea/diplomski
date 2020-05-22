String converted = String.valueOf(accountNumber); 
String pattern2 = "^\\d{1,10}$" ;
if (!converted.matches(pattern2)) { // use the converted String to compare
    return false;
} else {
    this.AccountNumber = accountNumber;
    return true;
}