double total2 = total;

//Loop
...
//End Loop

int counter = -1;
while(total2 >= 40) {
    counter++;
    total2 = total2 + 0.9;
}
System.out.print("\nThis work can be up to " + counter+ " days late before failing.");