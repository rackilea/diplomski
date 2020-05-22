for(int i = 0; i < index; i++) // also change your index 
{
    if(string.charAt(k) == ' ')
    {
        charString[i] = '%';
        charString[i+1] = '2';
        charString[i+2] = '0';
        i = i +2;
    }
    else
    { // these braces are not needed now but inculde them to make my 
      // point above valid
        charString[i] = string.charAt(k);
    }
    //increment every time
    k++;
}