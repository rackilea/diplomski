"last",(.*?)$

Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Greedy quantifiers

Match the character string “"last",” literally (case sensitive) «"last",»
Match the regex below and capture its match into backreference number 1 «(.*?)»
   Match any single character that is NOT a line break character (line feed) «.*?»
      Between zero and unlimited times, as few times as possible, expanding as needed (lazy) «*?»
Assert position at the end of the string, or before the line break at the end of the string, if any (line feed) «$»