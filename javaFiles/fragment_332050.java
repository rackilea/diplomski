int digcheck=0,charcheck=0,symbcheck=0,caseCheck=0;
    for (int i = 0; i < passwordraw.length(); i++) {
         if (Character.isDigit(passwordraw.charAt(i)))
         {
            digcheck++; 
         }
         else if(Character.isLetter(passwordraw.charAt(i))) 
         {
            charcheck++;
            if(Character.isUpperCase(passwordraw.charAt(i))){
              caseCheck++;
            }
         }
         else
         {
            symbcheck++; 
         }              
    }
    if(digcheck<3)
    {
        digcheck=0;
        throw new OBSSecurityException("INVALID PASSWORD! Must have atleast three(3) digits.");
    }else if(charcheck<5)
    {
        charcheck=0;
        throw new OBSSecurityException("INVALID PASSWORD! Must have atleast five(5) alpha.");
    }
    else if(symbcheck<1)
    {
        symbcheck=0;
        throw new OBSSecurityException("INVALID PASSWORD! Must have atleast one(1) symbol.");
    }
   else if(caseCheck<1)
    {
        caseCheck=0;
        throw new OBSSecurityException("INVALID PASSWORD! Must have atleast one(1) Uppercase Letter.");
    }