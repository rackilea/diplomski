# "((?:(?!\\bis\\b)\\S+\\s*){0,2})\\bis\\b\\s*(?=((?:(?!\\bis\\b)\\S+\\s*){0,2}))"

 (                             # (1 start), 0-2 words before
      (?:
           (?! \b is \b )                # But, not the target word
           \S+ \s* 
      ){0,2}
 )                             # (1 end)
 \b is \b \s* 
 (?=                           # Lookahead, Overlap so next search starts here.
      (                             # (2 start), 0-2 words after
           (?:
                (?! \b is \b )                # But, not the target word
                \S+ \s* 
           ){0,2}
      )                             # (2 end)
 )