^           # beginning-of-the-string anchor
\{          # match a literal { character
    \d+     # first element
    (?:     # beginning of the non-capturing group
       ,    # followed by a comma
      \s*   # and optional whitespace
      \d+   # and one or more elements
    )*      # make the whole group optional; allow for values like {1}
\}          # match a literal } character
$           # end-of-the-string anchor