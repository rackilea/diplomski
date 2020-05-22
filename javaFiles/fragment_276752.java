(?<=                     look behind to see if there is:
    \b                       the word boundary
    test:                    'test:'
  )                        end of look-behind
  {                        '{'
  [^}]*                    any character except: '}' (0 or more times)
  }                        '}'