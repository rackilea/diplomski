^        # Start of string
[=+\s]*  # Optionally match =, + or whitespace
(?:      # Start of group:
 [0-9]   # Match a digit
 [=+\s]* # Optionally match =, + or whitespace
){8,}    # Repeat at least 8 times
$        # End of string