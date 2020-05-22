^                                # match the start of the string (not needed with the matches() method)
    (?:                          # start of a non capturing group
        (?!(?<!\d)\d{3}(?!\d))   # combined lookarounds, fails if there are 3 digits following with not a digit before and ahead of those 3 digits
        [a-zA-Z\d]               # match one ASCII letter or digit
    )+                           # repeat this at least once
$                                # match the end of the string (not needed with the matches() method)