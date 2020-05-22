curr <- 0
count <- 0 //integer imitates the stack for this simple usage
l <- string.length()
while (curr < l):
   if string.charAt(curr) == '{':
         count++;
   else if string.charAt(curr) == '}':
         if curr <= 0:
              return ERROR;
         count--;
   curr++;
if count != 0:
    return ERROR;
return SUCCESS;