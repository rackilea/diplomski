(                        group and capture to \1:
    \(                       '('
    \d{3}                    digits (0-9) (3 times)
    \)                       ')'
   |                        OR
    \d{3}                    digits (0-9) (3 times)
  )                        end of \1

  (                        group and capture to \2:
    [.-]                     any character of: '.', '-'
  )                        end of \2

  \d{3}                    digits (0-9) (3 times)
  \2                       what was matched by capture \2
  \d{4}                    digits (0-9) (4 times)