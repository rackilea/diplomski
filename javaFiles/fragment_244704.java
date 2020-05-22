(?:                            | start non-capturing group 1
  \{                           |   match the character '{'
  sup                          |   match the substring: "sup"
  \s                           |   match any white space character
)                              | end non-capturing group 1
?                              | ...and repeat it once or not at all
(                              | start group 1
  \d                           |   match any character in the range 0..9
)                              | end group 1
(?=                            | start positive look ahead
  \d                           |   match any character in the range 0..9
  *                            |   ...and repeat it zero or more times
  }                            |   match the substring: "}"
)                              | stop negative look ahead
}                              | match the substring: "}"
?                              | ...and repeat it once or not at all