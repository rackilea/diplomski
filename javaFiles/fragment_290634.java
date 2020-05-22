^        # Start of string
(?=      # Assert that the following could be matched here:
 .*      # Any number of characters
 (?:0*1) # followed by any number of 0s and exactly one 1
 {3}     # three times
)        # End of lookahead
[01]*    # Match any number of ones or zeroes
00       # Match two zeroes
$        # at the end of the string