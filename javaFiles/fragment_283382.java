^                                   : beginning of the string
    (?:                             : start non capture group
        [1-9][0-9]{0,2}             : 1 digit from 1 to 9, followed by optional 1 or 2 digits (i.e. from 1 to 999)
      |                             : OR
        1000                        : 1000
    )                               : end group
    (?:                             : start non capture group
         +                          : 1 or more spaces
        (?:[1-9][0-9]{0,2}|1000)    : same as above
    )*                              : group may appear 0 or more times
$                                   : end of string