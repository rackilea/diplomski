//store last input, current input, and the sum
int last = 0;
int result = 0;
int input = 0;
//note that if you enter invalid input, this will go into an infinite loop
while ((input = scan.nextInt()) > last){
    result += input; //directly adds the input to the sum
    last = input;
}
System.out.println("Sum: " + result);