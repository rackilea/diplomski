int count = 0;
if (userinput1.equals(answer1)) {
    count++;
}
if (userinput2.equals(answer2)) {
    count++;
}
if (userinput3.equals(answer3)) {
    count++;
}
String[] result = { "0/3 None", "1/3 Try Again.", "2/3 Good Job.", "3/3 Awesome!" };
System.out.println(result[count]);