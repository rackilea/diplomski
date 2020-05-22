\\{%         # { need to be escaped
(?>          # open an atomic group *
   [^%]++    # all characters but %, one or more times (possessive *)
  |          # OR
   %(?!})    # % not followed by } (<-no need to escape)
)*           # close the atomic group, repeat zero or more times
%}