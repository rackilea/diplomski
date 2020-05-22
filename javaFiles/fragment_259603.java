// original = "section" string
exploded = ""
prevdigits = false
for ii from 1 to length(original) {
   ch = original[ii]
   if (ch is a digit) then {
      if not prevdigits then {
         token = ""
         prevdigits = true
      }
      token = token+ch
   } else { // letter
      if prevdigits then {
         exploded = exploded + spaces(5-length(token)) + token
         prevdigits = false
      }
      exploded = exploded + ch
   }
}