s = size(input) 
result = ""
for (i = 0; i < s; i++) {
   if input[i] is numeric
      result += "d"
   else if input[i] is word
      result += "w" 
   ...
}
return result