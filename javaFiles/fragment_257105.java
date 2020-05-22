// store the value in the field minutes.
double minutes;

double years = minutes/(60*24*365.2425);

/* 
This will ignore the part after the decimal. 
The part after the decimal is not a complete year, 
so it'll be used to calculate the number of days. 
*/
int absoluteYears = (int)years; 

double days = (years - absoluteYears)*365.2425;