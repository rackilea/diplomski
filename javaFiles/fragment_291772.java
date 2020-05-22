boolean checkPotentialPalindrom(char[] cAr, start, end, altcnt){
       if (end <= start)
             return true

       if (cAr[start] != cAr[end])
            altcnt = altcnt + 1

       if (altcnt > 1) 
             return false

       return checkPotentialPalindrom(cAr, start + 1, end - 1, altcnt)
 }