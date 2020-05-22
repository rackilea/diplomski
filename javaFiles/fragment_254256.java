//apply the shift to each character
    strChars[i] += numShift;

    //wrap around if the shift is beyond Z
    **if(strChars[i] > 'z') 
        {
        strChars[i] -= 'z';
        strChars[i] += ('a' - 1);         
        }**