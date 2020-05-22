eCount = 0;
aCount = 0;
lCount = 0;
for (int i = 0; i < s.length(); i++) {
   switch(s.charAt(i)) {
      case 'e':
         eCount++;  
         break;
      case 'a':
         aCount++;
         break;
      case 'l':
         lCount++;
         break;
   }
}
if (eCount >= 2 && aCount >= 1 && lCount >= 1) { ... }