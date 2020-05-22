int day;
// day is uninitialized
if(month == 1||month == 3||...){
    int z1 = r3.nextInt(30);
    day = 1 + z1;
}
else if(month == 2||month == 4||month == 6||month == 9||month == 11){
    int z2 = r3.nextInt(29);
    day = 1 + z2;
}
else if(month == 2 & year%4 ==0){
    int z3 = r3.nextInt(28);
    day = 1 + z3;
}
else if(month == 2 & year%4 != 0){
    int z4 = r3.nextInt(27);
    day = 1 + z4;
}
// if the month wasn't between 1 and 12, day is still uninitialized