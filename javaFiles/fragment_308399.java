int sum = 0; 
int input = int1; 
while (input != 0) {
   int lastdigit = input % 10;  //(right to left) one's to tens to hundreds place value
   sum += lastdigit; // sum = sum + lastDigit
   input /= 10; // your if..else can be based on this value
}