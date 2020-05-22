double inside = (1 + interest / 365);
//repayments is the result from A
double numerator = (Math.pow(inside, 365 * n) -1);
double denominator = (Math.pow(inside, frequency) -1);

double first = loan * Math.pow(inside, 365 * n);
double last = - repayments * numerator / denominator;

double total =  first + last;