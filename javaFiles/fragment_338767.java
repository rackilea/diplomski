str = str + ": ";

if(this.quarters > 1)
    str = str + this.quarters + " quarters, ";
else if(this.quarters == 1)
    str = str + "1 quarter, ";

if(this.dimes> 1)
    str = str + this.dimes+ " dimes, ";
else if(this.dimes== 1)
    str = str + "1 dime, ";

// same thing for nickels and pennies

str = str.substring(0, str.length() - 2); // cut off the last two characters, i.e. the extra comma and space