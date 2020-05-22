Try this, it should work.

"07[3-9][0-9]{8}"  

What this mean is,   
07 - it tries to find literally 07  
[3-9] - then followed by 3 to 9, only one time
[0-9] - then followed by 0 to 9  
{8} - text previous to this should has at least 8 characters.