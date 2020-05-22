^            from the start of the string
(?=.*[?@$])  assert that we see a special character anywhere, at least once
.{2}         then match any two characters
b            match a 'b' for the 3rd character
.{2}         then match any two characters again
$            end of string