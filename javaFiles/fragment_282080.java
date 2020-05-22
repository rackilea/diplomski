int i = 1;
boolean correct = (solution == readInt("What is " + x + "+" + y + "?"));
while (i < CHANCES && !correct) {
    correct = (solution == readInt("Wrong, try again."));
    i++;
}
if (correct) {
    println("Well done!");
} else {
    println("Nope, the answer is: "+solution);
}