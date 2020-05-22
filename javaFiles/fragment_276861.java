switch(operator) {
case "+": answer = numone + numtwo; break;
case "-": answer = numone - numtwo; break;
case "*": answer = numone * numtwo; break;
case "/": answer = numone / numtwo; break;
// any other operators you want go here
default: throw new RuntimeException(operator+" isn't a valid operator!");
}