(?=[&|=\s])  # make sure there is at least a single separator character ahead;
             # this is important, otherwise you would get empty matches, and
             # depending on your implementation split every non-separator
             # character apart.
[&|\s]*      # same as before but leave out =
(?:          # start a (non-capturing) group; it will be optional and treat the
             # special =...| case
  =          # match a literal =
  [^|]*?     # match 0 or more non-| characters (as few as possible)
  [|]        # match a literal | ... this is the same as \|, but this is more
             # readable IMHO
  [&|=\s]+   # and all following separator characters
)?           # make the whole thing optional