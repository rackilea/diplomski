#                        '#'
[A-Z]{3}                 any character of: 'A' to 'Z' (3 times)
\d                       digits (0-9)
(?:                      group, but do not capture (optional):
  _                        '_'
  \d{1,2}                  digits (0-9) (between 1 and 2 times)
)?                       end of grouping
#                        '#'