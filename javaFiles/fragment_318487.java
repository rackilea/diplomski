^           : begining of line, not mandatory when using matches()
(?=.{7}$)   : lookahead, make sure we have exactly 7 characters
\\d{1,2}    : 1 or 2 digits
M           : M
S?          : optional S
\\s*        : 0 or more spaces
$           : end of line, not mandatory when using matches()