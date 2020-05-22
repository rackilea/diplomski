^                  // the start of the string
(?=.*[a-z])        // use positive look ahead to see if at least one lower case letter exists
(?=.*[A-Z])        // use positive look ahead to see if at least one upper case letter exists
(?=.*[0-9])        // use positive look ahead to see if at least one digit exists
(?=.{8,})           // use positive look ahead to see if length of string is at least 8 charachters
(?=.*[*/&%^*$#@!~+_]) // use positive look ahead to see if at least one special character exists
.+                 // gobble up the entire string
$                  // the end of the string