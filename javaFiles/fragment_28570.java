/\A 
  (?=.{8,16}\z)                     # Must contain 8-16 characters
  (?!.*[^a-zA-Z\d!@#$%&\/=?_.,:;-]) # Must not contain other characters
  (?=.*\d)                          # Must contain a digit
  (?=.*[a-z])                       # Must contain a lower case character
  (?=.*[A-Z])                       # Must contain an upper case character
  (?=.*[!@#$%&\/=?_.,:;-])          # Must contain a symbol from this list
/x