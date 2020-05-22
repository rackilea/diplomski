System.out.println("State bulb 64: " + bulbs[63]); // if we assume bulbs[0] is considered as bulb number 1
int count = 0; 
for (int i=0; i<bulbs.length; i++) {
    if (bulbs[i]) 
        count++;
}
System.out.println("# lightbulbs on:" + count);