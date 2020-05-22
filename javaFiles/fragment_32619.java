\{\{         # literal "{{", followed by
wotd         # literal "wotd", followed by
\|           # literal "|", followed by
([^|]+)      # one or more characters which are not a "|" (captured), followed by
\|           # literal "|", followed by
([^|]+)      # one or more characters which are not a "|" (captured), followed by
\|           # literal "|", followed by
([^#|]+)     # one or more characters which are not "|" or "#", followed by
[^|}]*       # zero or more characters which are not "|" or "}", followed by
(?:          # begin group
  \|         # a literal "|", followed by
  [^|}]*     # zero or more characters which are not "|" or "}"
)            # end group
*            # zero or more times, followed by
\}\}         # literal "}}"