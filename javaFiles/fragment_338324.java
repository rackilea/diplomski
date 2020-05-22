// before this the input has been checked, as in OP's code

fifties = 0;
if (mod(input,20)==10) {
    fifties = 1;
} 
remainder = input - fifties*50;

// hundreds will be 0 if remainder is less than 100
hundreds = remainder / 100;
remainder = remainder-(hundreds*100);
twenties = remainder / 20;

// now print the results