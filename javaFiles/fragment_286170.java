String message = ""; //a string to store the whole message
for (int c = stack.length - 1; c >= 0; c--) {
  message += ", "+stack[c];  //add the next element to the message
}
message = message.substring(2); //cut off the first ", "
return message;