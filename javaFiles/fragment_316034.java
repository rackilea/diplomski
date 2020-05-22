\d{4} match a digit [0-9]

    Quantifier: {4} Exactly 4 times

(?:-\d{2}){2} Non-capturing group

    Quantifier: {2} Exactly 2 times
    - matches the character - literally
    \d{2} match a digit [0-9]
        Quantifier: {2} Exactly 2 times

T matches the character T literally (case sensitive)
\d{2} match a digit [0-9]

    Quantifier: {2} Exactly 2 times

(?::\d{2}){2} Non-capturing group

    Quantifier: {2} Exactly 2 times
    : matches the character : literally
    \d{2} match a digit [0-9]
        Quantifier: {2} Exactly 2 times