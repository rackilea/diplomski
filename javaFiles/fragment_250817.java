int min, max;

switch(input){
case 1:      // i<10 && i>5
    min = 6;
    max = 10;
    break; // to avoid follow-through to the next case
case 2:     // i>=10 && i<19
    min = 10;
    max = 20;
    break;
case 3:     // i>19 && i<24
    min = 20;
    max = 25;
    break;
default:
    // You need something here in case the value entered wasn't 1-3
}
for (int i = min; i < max; ++i) {
    // ...
}