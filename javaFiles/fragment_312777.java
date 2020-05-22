# matches that don't start with wildcards
([1-9])    # get a digit, and capture for future reference
(\1|w){2,} # the captured digit, or the letter w, 2 or more times
|          # or, matches that start with a single w
w          # match a w
([1-9])    # get a digit, and capture for future reference
(\3|w)+    # get one or more of the captured digit, or letter w
|          # or, matches starting with two w
ww         # get two w
([1-9])    # get a digit, and capture for future reference
\5*        # get all the successive captured digits