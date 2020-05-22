^       # Match the start of the string
(?!     # Make sure it's impossible to match...
 (?:    # the following:
  [^.]* # any number of characters except dots
  \\.   # followed by a dot
 ){3}   # exactly three times.
 [^.]*  # Now match only non-dot characters
 $      # until the end of the string.
)       # End of lookahead